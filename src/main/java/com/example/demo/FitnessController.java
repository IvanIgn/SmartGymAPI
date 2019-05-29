package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class FitnessController {

    private Fitness fitness = new Fitness();

    @RequestMapping(value = "/gyms", method = RequestMethod.GET)
    public List<Gym> getGyms(@RequestParam(value = "searchId", defaultValue = "") String searchId) {

        return fitness.getGymList(searchId);
    }

    @RequestMapping(value = "/gyms", method = RequestMethod.POST)
    public Gym postGymsItem(@RequestBody Gym gymGym) {

        fitness.addItem(gymGym);
        return gymGym;
    }


    @RequestMapping(value = "/gyms/{id}", method = GET)
    public Gym getItem(@PathVariable("id") String itemId) {

        Gym item = fitness.getFitnessItem(itemId);

        return item;
    }

    @RequestMapping(value = "/gyms/{id}", method = DELETE)
    public Gym deleteGymItem(@PathVariable("id") String itemId) {

        return fitness.deleteGym(itemId);
    }


    // vid patch kan vi inte mappa body mot en InventoryItem
// utan måste mappa den mot en MAP (dictionary)
// Patch -  @RequestBody Map<Object, Object> itemFields
    @RequestMapping(value = "/gyms/{id}", method = PUT)
    public Gym putGymItem(@PathVariable("id") String itemId,
                          @RequestBody Gym item) {

        fitness.replaceItemWithId(itemId, item);
        return item;
    }

//////////////// members //////////////////

    @RequestMapping(value = "/gyms/{id}/members", method = RequestMethod.POST)
    public Member postMembersItem(@PathVariable("id") String itemId,
                                  @RequestBody Member member) {

        fitness.addMembersToArray(itemId, member);
        return null;
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<Member> getMembersItems(@RequestParam(value = "name", defaultValue = "") String name)
    {
       return fitness.getMembersList(name);
    }

    @RequestMapping(value = "/members/{id}", method =RequestMethod.DELETE)
    public Member deleteMemberItem(@PathVariable(value = "id") String id)
    {
      return fitness.deleteMember(id);
    }

    @RequestMapping(value = "gyms/{gymId}/members/{memberId}", method =RequestMethod.DELETE)
    public Member deleteMemberItem(@PathVariable(value = "gymId") String gymId, @PathVariable(value = "memberId") String memberId)
    {
        return fitness.deleteMemberItem(gymId, memberId);
    }

    @RequestMapping(value = "gyms/{gymId}/members/{memberId}", method = GET)
    public Member getMemberItem(@PathVariable(value = "gymId") String gymId, @PathVariable(value = "memberId") String memberId)
    {
        return fitness.getMemberItem(gymId, memberId);
    }

}
