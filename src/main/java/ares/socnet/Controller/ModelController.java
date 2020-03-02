package ares.socnet.Controller;

import ares.socnet.exeptions.NotFoundExeption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("message")
public class ModelController {
    public List<Map<String, String>> messages = new ArrayList<>() {{
        add(new HashMap<String, String>() {{ put("id", "1"); put("text","111"); }});
        add(new HashMap<String, String>() {{ put("id", "2"); put("text","222"); }});
        add(new HashMap<String, String>() {{ put("id", "3"); put("text","333"); }});

    }};
    @GetMapping
    public List<Map<String, String>> list(){
        return messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id) {
        return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundExeption::new);
    }
    }

