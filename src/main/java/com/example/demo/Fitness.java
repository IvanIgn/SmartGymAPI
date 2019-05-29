package com.example.demo;

import java.util.List;
import java.util.ArrayList;

public class Fitness {

    private List<Gym> gymList;



    public Fitness() {
        this.gymList = new ArrayList<>();
        addData();
    }


    public List<Gym> getGymList(String searchId) {

        if (searchId.equals(""))
            return gymList;


        ArrayList<Gym> items = new ArrayList<>();

        for (Gym item: gymList) {
            if(item.getName().toLowerCase().contains(searchId.toLowerCase()))
                items.add(item);
        }

        return items;

    }


    public List<Member> getMembersList(String name) {


            ArrayList<Member> items = new ArrayList<>();

            for (Gym gymItem: gymList){
                for (Member memberItem: gymItem.getMembers()) {
                    if(memberItem.getName().toLowerCase().contains(name.toLowerCase()))
                        items.add(memberItem);
                }

            }


        return items;
    }

    public Gym getFitnessItem(String id) {

        return findItemById(id);
    }

    public Gym deleteGym(String id) {
        Gym item = findItemById(id);

        gymList.remove(item);

        return item;
    }

    public Member deleteMember(String id) {

        for (Gym gymItem : gymList) {
            for (Member memberItem : gymItem.getMembers()) {
               if (memberItem.getId().equals(id)){
                   gymItem.getMembers().remove(memberItem);
               }
               return memberItem;
            }
        }
        return null;
    }

    public void addItem(Gym item) {
        gymList.add(item);
    }

    public void replaceItemWithId(String id, Gym newItem) {
        Gym oldItem = findItemById(id);

        gymList.remove(oldItem);

        newItem.setId(oldItem.getId());

        gymList.add(newItem);

    }

    private Gym findItemById(String id) {
        for(Gym item : gymList) {
            if (item.getId().equals(id))
                return item;
        }

        return null;
    }


    private void addData() {
       // Member member1 = new Member("1", "John");
       // Member member2 = new Member("2", "Jack");
       // Member member3 = new Member("3", "Mike");
        Gym gym1 = new Gym("1","Gold Gym");
        Gym gym2 = new Gym("2","Silver Gym");
        Gym gym3 = new Gym("3","Bronze Gym");

        gymList.add(gym1);
        gymList.add(gym2);
        gymList.add(gym3);
    }

            //// members ////

    public void addMembersToArray(String itemId, Member member) {
       // this.members.add(member);
        for (Gym memberID: gymList) {
            if(memberID.getId().equals(itemId))
              memberID.getMembers().add(member);
        }
       // this.addMembers(itemId,member);
    }


    public Member deleteMemberItem(String gymId, String memberId) {
        for (Gym gymItem : gymList) {
            if (gymItem.getId().equals(gymId))
                for (Member memberItem : gymItem.getMembers()) {
                    if (memberItem.getId().equals(memberId))
                        gymItem.getMembers().remove(memberItem);

                    return memberItem;
                }
            }

        return null;
    }


    public Member getMemberItem(String gymId, String memberId) {

        for (Gym gymItem : gymList) {
            if (gymItem.getId().equals(gymId))
                for (Member memberItem : gymItem.getMembers()) {
                    if (memberItem.getId().equals(memberId))

                    return memberItem;
                }
        }
        return null;
    }
}
