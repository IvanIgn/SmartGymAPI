package com.example.demo;

import java.util.ArrayList;

public class Gym {
    private String id;
    private String name;
    private ArrayList<Member> members = new ArrayList<>();



    public Gym(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
       this.members = members;
    }

    public void addMembersToArray(Member member) {
        this.members.add(member);
    }



}
