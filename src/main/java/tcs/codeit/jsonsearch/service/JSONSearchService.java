package tcs.codeit.jsonsearch.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import tcs.codeit.jsonsearch.dto.JSONSearchResultDTO;

@Service
public class JSONSearchService {
	
	private static List<JSONSearchResultDTO> jsonNodeFieldList = new ArrayList<>();
	
	public List<JSONSearchResultDTO> searchJSONForOccurance(String jsonString,String searchKey ) {
		List<JSONSearchResultDTO> searchResult = new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
		    JsonNode jsonNode = mapper.readTree(jsonString);
		    getAllKeys(jsonNode,1,"NA","NA");
		    for(JSONSearchResultDTO jsonSearchResultDTO : jsonNodeFieldList) {
		    	if(jsonSearchResultDTO.getKey().contains(searchKey)) {
		    		searchResult.add(jsonSearchResultDTO);
		    	}
		    }
		    jsonNodeFieldList.clear();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return searchResult;
	}
	
	private void getAllKeys(JsonNode jsonNode, Integer level,String parent,String path) {
		Iterator<Map.Entry<String, JsonNode>> nodes = jsonNode.fields();
	    Map.Entry<String, JsonNode> node = null;
	    while (nodes.hasNext()) {
	    	node = nodes.next();
	    	JSONSearchResultDTO jsonSearchResultDTO = new JSONSearchResultDTO();
	    	jsonSearchResultDTO.setKey(node.getKey());
	    	jsonSearchResultDTO.setLevel(Integer.toString(level));
	    	jsonSearchResultDTO.setParent(parent);
	    	jsonSearchResultDTO.setDataType(node.getValue().getNodeType().toString());
	    	if(!node.getValue().getNodeType().toString().equalsIgnoreCase("OBJECT") && !node.getValue().getNodeType().toString()
	    			.equalsIgnoreCase("ARRAY")) {
	    		jsonSearchResultDTO.setPath(path);
	    	}else if(node.getValue().getNodeType().toString().equalsIgnoreCase("OBJECT")){
	    		if(path.equalsIgnoreCase("NA")) {
	    			getAllKeys(node.getValue(),level+1,node.getKey(),node.getKey()+".");
	    		}else {
	    			getAllKeys(node.getValue(),level+1,node.getKey(),path+node.getKey()+".");
	    		}
	    		jsonSearchResultDTO.setPath(path);
	    	}else {
		        for (int i = 0; i < node.getValue().size(); i++) {
		        	if(path.equalsIgnoreCase("NA")) {
		        		getAllKeys(node.getValue().get(i),level+1,node.getKey(),node.getKey()+".");
		    		}else {
		    			getAllKeys(node.getValue().get(i),level+1,node.getKey(),path+node.getKey()+".");
		    		}
		        }
		        jsonSearchResultDTO.setPath(path);
	    	}
	    	jsonNodeFieldList.add(jsonSearchResultDTO);
	    }
	    level--;
	}
}
