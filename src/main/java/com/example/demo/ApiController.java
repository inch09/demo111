package com.example.demo;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
@RestController
public class ApiController {
    List<Club> clubs = new ArrayList<>();

    @PostMapping(value = "/clubs")
    public ResponseEntity<Integer> plusClub(@RequestBody Club club) {
        clubs.add(club);
        return ResponseEntity.ok(clubs.size() - 1);
    }

    @GetMapping(value = "/clubs/{id}")
    public ResponseEntity<Club> vydachaClub(@PathVariable(name = "id") int id) {
        Club club = new Club(clubs.get(id).getId(), clubs.get(id).getNazvanie(), clubs.get(id).getOpisanie());
        return ResponseEntity.ok(club);


    }

    @PutMapping(value = "/clubs/{id}")
    public ResponseEntity<Integer> obnovitClub(@PathVariable(name = "id") int id, @RequestBody Club club) {
        clubs.get(id).setNazvanie(club.getNazvanie());
        clubs.get(id).setOpisanie(club.getOpisanie());
        return ResponseEntity.ok(id);

    }

    @DeleteMapping(value = "/clubs/{id}")
    public ResponseEntity<Integer> deleteClub(@PathVariable(name = "id") int id) {
        clubs.remove(id);
        return ResponseEntity.ok(id);

    }

    List<Member> members = new ArrayList<>();

    @PostMapping(value = "/members")
    public ResponseEntity<Integer> plusMember(@RequestBody Member member) {
        members.add(member);
        return ResponseEntity.ok(members.size() - 1);
    }

    @GetMapping(value = "/members/{id}")
    public ResponseEntity<Member> vydachaMember(@PathVariable(name = "id") int id) {
        Member member = new Member(id, members.get(id).getName(), members.get(id).getKlass(), members.get(id).getPochta());
        return ResponseEntity.ok(member);


    }

    @PutMapping(value = "/members/{id}")
    public ResponseEntity<Integer> obnovitMember(@PathVariable(name = "id") int id, @RequestBody Member member) {
        members.get(id).setName(member.getName());
        members.get(id).setKlass(member.getKlass());
        members.get(id).setPochta(member.getPochta());
        return ResponseEntity.ok(id);

    }

    @DeleteMapping(value = "/member/{id}")
    public ResponseEntity<Integer> deleteMember(@PathVariable(name = "id") int id) {
        members.remove(id);
        return ResponseEntity.ok(id);

    }

    List<Event> events = new ArrayList<>();

    @PostMapping(value = "/events")
    public ResponseEntity<Integer> plusEvent(@RequestBody Event event) {
        events.add(event);
        return ResponseEntity.ok(events.size() - 1);
    }

    @PostMapping(value = "/events/{eventId}/invite?memberId={id}")
    public ResponseEntity<Integer> priglashenie(@PathVariable String id , @PathVariable String eventId) {
        members.get(Integer.parseInt(id)).membersPriglashenie.add(Integer.parseInt(eventId));
        return ResponseEntity.ok(1);
    }
    @PostMapping(value = "/events/{eventId}/attendance?memberId=&status={Status}")
    public ResponseEntity<Integer> otmetit(@PathVariable String eventId , @PathVariable String memberId,@PathVariable String Status) {
        if(Status.equals("присутствует")|| Status.equals("опоздал"))
        members.get(Integer.parseInt(memberId)).poseschennyeEvents.add(Integer.parseInt(eventId));
        return ResponseEntity.ok(1);
    }
    @GetMapping(value = "/events/{eventId}/attendance")
    public ResponseEntity<Integer> posmotretPoseschenie(@PathVariable(name = "eventId") int eventId) {
        int kolichestvoPosetivshih = 0;
        for(Member a:members){
            for (int b:a.poseschennyeEvents){
                if(b==eventId){
                    kolichestvoPosetivshih++;
                }
            }
        }
        return ResponseEntity.ok(kolichestvoPosetivshih);


    }







































    }








