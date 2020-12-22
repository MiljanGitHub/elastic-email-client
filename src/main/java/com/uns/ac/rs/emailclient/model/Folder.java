package com.uns.ac.rs.emailclient.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Entity;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Table(name = "folder")
@Entity
@Getter
@Setter
public class Folder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folder_id", unique = true, nullable = false)
    private int id;

    @NonNull
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent_folder", orphanRemoval = true)
    @Column(name = "sub_folders")
    private Set<Folder> childFolders = new HashSet<>();


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "folder", orphanRemoval = true)
    @Column(nullable = false)
    private Set<Message> messages = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "parent_folder_id", referencedColumnName = "folder_id", nullable = true)
    private Folder parent_folder;


    public Folder() {}

    public Folder(int id, @NonNull String name,Set<Folder> childFolders, Account account, Folder parent_folder) {
        this.id = id;
     
        this.name = name;
      
        this.childFolders = childFolders;
        this.account = account;
        this.parent_folder = parent_folder;
    }

    public Folder (boolean isActive, @NonNull String name, Account account){

       
        this.name = name;
        this.account = account;
    }
}
