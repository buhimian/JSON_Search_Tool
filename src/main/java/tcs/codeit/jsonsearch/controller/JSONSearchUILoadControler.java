package tcs.codeit.jsonsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/load")
public class JSONSearchUILoadControler {
	
	@GetMapping("/JSONSearcher")
	public String getJSONSearchPage() {
		return "JSONSearcher";
	}

}
