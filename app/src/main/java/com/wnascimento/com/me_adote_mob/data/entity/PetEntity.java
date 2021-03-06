package com.wnascimento.com.me_adote_mob.data.entity;

import com.wnascimento.com.me_adote_mob.domain.owner.OwnerContract;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.domain.pet.Pet;

import java.io.Serializable;


public class PetEntity implements Serializable {

    private String id;
    private String name;
    private String image;
    private String breed;
    private int gender;
    private String notes;
    private long dateBirth;
    private boolean adopted;
    private double weight;
    private double height;
    private long createdAt;
    private long ownerId;



    public PetEntity(String id, String name, String image, String breed, int gender, String notes,
                     long dateBirth, boolean adopted, double weight, double height, long createdAt, long ownerId) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.breed = breed;
        this.gender = gender;
        this.notes = notes;
        this.dateBirth = dateBirth;
        this.adopted = adopted;
        this.weight = weight;
        this.height = height;
        this.createdAt = createdAt;
        this.ownerId = ownerId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public long getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(long dateBirth) {
        this.dateBirth = dateBirth;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public PetContract toModel(OwnerContract owner) {
        return new Pet.PetBuilder()
                .setId(id)
                .setName(name)
                .setImage(image)
                .setBreed(breed)
                .setDateBirth(dateBirth)
                .setAdopted(adopted)
                .setGender(gender)
                .setHeight(height)
                .setWeight(weight)
                .setNotes(notes)
                .setOwner(owner)
                .setCreatedAt(createdAt)
                .build();
    }

    @Override
    public String toString() {
        return "PetEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", breed='" + breed + '\'' +
                ", gender=" + gender +
                ", notes='" + notes + '\'' +
                ", dateBirth=" + dateBirth +
                ", adopted=" + adopted +
                ", weight=" + weight +
                ", height=" + height +
                ", createdAt=" + createdAt +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
