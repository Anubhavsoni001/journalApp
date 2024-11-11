package com.anubhav.journalApp.Controller;


import com.anubhav.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
    private Long myId;


    @GetMapping
      public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
         journalEntries.put(myEntry.getId(), myEntry);
         return true ;
    }


    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@Pathvariable Long myId){
        return journalEntries.get(myId);
    }


    @DeleteMapping("id/{myId}")
        public JournalEntry deleteJournalEntryById(@PathVariable Long myId){

        return journalEntries.remove(myId);
    }
    @PutMapping()
    public  JournalEntry updateJournalEntry(@PathVariable Long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);

    }

}
