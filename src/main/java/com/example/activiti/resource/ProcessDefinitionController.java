package com.example.activiti.resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.activiti.EntityFactory;

@Controller
@RequestMapping("/processDefinition")
public class ProcessDefinitionController {

	@Autowired
	private RepositoryService repositoryService;

	@RequestMapping(value = "/{id}", method = GET)
	public @ResponseBody ProcessDefinition getProcessDefinition(@PathVariable String id) {

		return EntityFactory.convertProcessDefinition(
				repositoryService.createProcessDefinitionQuery().deploymentId(id).singleResult());
	}

	@RequestMapping(method = GET)
	public @ResponseBody Iterable<ProcessDefinition> getProcessDefinition() {
		List<ProcessDefinition> list = new ArrayList<>();
		repositoryService.createProcessDefinitionQuery().list()
				.forEach(p -> list.add(EntityFactory.convertProcessDefinition(p)));
		return list;
	}

	@RequestMapping(value = "/diagram/{id}", method = GET)
	public ResponseEntity<byte[]> getProcessDiagram(@PathVariable String id ) throws IOException {

		InputStream in = repositoryService.getProcessDiagram(id);
		long length =0;
		final int SIZE = 1024;
		byte[] imgbuffer = new byte[1024*1024*2];
		for(int i=0; ; i++){
		 	int read =  in.read(imgbuffer, SIZE*i, SIZE );
		 	length += read;
		 	if( read < SIZE){
		 		break;
		 	}
		}
		
		return creat (imgbuffer);
		 
	}
	
	
	private static ResponseEntity<byte[]> creat(byte[] bytes){
		 try {
	            HttpHeaders header = new HttpHeaders();
	            header.setContentType(MediaType.IMAGE_PNG);
	          //  if you want save this stream as a attachment, uncomment this line.  
	          //  header.setContentDispositionFormData("attachment" , "bpmn.png");
	            return new ResponseEntity<byte[]>(bytes, header, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
	        }
	}

}
