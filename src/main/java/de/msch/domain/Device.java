package de.msch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Device.
 */
@Entity
@Table(name = "device")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "device")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "device" }, allowSetters = true)
    private Set<Audiofile> audiofiles = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Device name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Audiofile> getAudiofiles() {
        return this.audiofiles;
    }

    public Device audiofiles(Set<Audiofile> audiofiles) {
        this.setAudiofiles(audiofiles);
        return this;
    }

    public Device addAudiofile(Audiofile audiofile) {
        this.audiofiles.add(audiofile);
        audiofile.setDevice(this);
        return this;
    }

    public Device removeAudiofile(Audiofile audiofile) {
        this.audiofiles.remove(audiofile);
        audiofile.setDevice(null);
        return this;
    }

    public void setAudiofiles(Set<Audiofile> audiofiles) {
        if (this.audiofiles != null) {
            this.audiofiles.forEach(i -> i.setDevice(null));
        }
        if (audiofiles != null) {
            audiofiles.forEach(i -> i.setDevice(this));
        }
        this.audiofiles = audiofiles;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Device)) {
            return false;
        }
        return id != null && id.equals(((Device) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Device{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
