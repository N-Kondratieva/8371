package models;

import java.util.ArrayList;

public class Pet extends Identified<Pet>{

    Id<Owner> ownerId;
    Id<Kind> kindId;
    Id<Species> speciesId;
    Id<Gender> genderId;
    Id<Service> serviceId;

    Pet(Id<Pet> id,  Id<Kind> kindId, Id<Owner> ownerId, Id<Species> speciesId, Id<Gender> genderId, Id<Service> serviceId) {
        super(id);
        this.ownerId = ownerId;
        this.kindId = kindId;
        this.speciesId = speciesId;
        this.genderId = genderId;
        this.serviceId = serviceId;

    }
    public Id<Owner> getOwnerId() {
        return ownerId;
    }
    public Id<Owner> setOwnerId() {
        return ownerId;
    }
    public Id<Kind> getKindId() {
        return kindId;
    }
    public Id<Kind> setKindId() {
        return kindId;
    }
    public Id<Species> getSpeciesId() {
        return speciesId;
    }
    public Id<Species> setSpeciesId() {
        return speciesId;
    }
    public Id<Gender> getGenderId() {
        return genderId;
    }
    public Id<Gender> setGenderId() {
        return genderId;
    }
    public Id<Service> getServiceId() {
        return serviceId;
    }
    public Id<Service> setServiceId() {
        return serviceId;
    }

}