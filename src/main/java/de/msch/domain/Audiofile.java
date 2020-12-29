package de.msch.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Audiofile.
 */
@Entity
@Table(name = "audiofile")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Audiofile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @NotNull
    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "album")
    private String album;

    @Column(name = "comment")
    private String comment;

    @Column(name = "genre")
    private String genre;

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "track")
    private String track;

    @Column(name = "total")
    private String total;

    @Column(name = "year")
    private String year;

    @Column(name = "fieldname")
    private String fieldname;

    @Column(name = "bitrate")
    private String bitrate;

    @Column(name = "bitspersample")
    private String bitspersample;

    @Column(name = "codec")
    private String codec;

    @Column(name = "covermimetype")
    private String covermimetype;

    @Column(name = "coversize")
    private String coversize;

    @Column(name = "covertype")
    private String covertype;

    @Column(name = "coverheight")
    private String coverheight;

    @Column(name = "coverwidth")
    private String coverwidth;

    @Column(name = "covers")
    private String covers;

    @Column(name = "lengthseconds")
    private String lengthseconds;

    @Column(name = "mode")
    private String mode;

    @Column(name = "samplerate")
    private String samplerate;

    @Column(name = "tool")
    private String tool;

    @Column(name = "vbr")
    private String vbr;

    @Column(name = "directory")
    private String directory;

    @Column(name = "extension")
    private String extension;

    @Column(name = "filename")
    private String filename;

    @Column(name = "filenameext")
    private String filenameext;

    @Column(name = "filenamerel")
    private String filenamerel;

    @Column(name = "folderpath")
    private String folderpath;

    @Column(name = "folderpathrel")
    private String folderpathrel;

    @Column(name = "parentdirectory")
    private String parentdirectory;

    @Column(name = "path")
    private String path;

    @Column(name = "volume")
    private String volume;

    @Column(name = "workingdir")
    private String workingdir;

    @Column(name = "workingpath")
    private String workingpath;

    @Column(name = "filecreatedate")
    private String filecreatedate;

    @Column(name = "filemoddate")
    private String filemoddate;

    @Column(name = "filesizebytes")
    private String filesizebytes;

    @Column(name = "crc_val")
    private String crcVal;

    @Column(name = "md_5_val")
    private String md5Val;

    @Column(name = "md_5_audio_val")
    private String md5audioVal;

    @Column(name = "app_val")
    private String appVal;

    @ManyToOne
    @JsonIgnoreProperties(value = { "audiofiles" }, allowSetters = true)
    private Device device;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audiofile id(Long id) {
        this.id = id;
        return this;
    }

    public String getArtist() {
        return this.artist;
    }

    public Audiofile artist(String artist) {
        this.artist = artist;
        return this;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    public Audiofile album(String album) {
        this.album = album;
        return this;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getComment() {
        return this.comment;
    }

    public Audiofile comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGenre() {
        return this.genre;
    }

    public Audiofile genre(String genre) {
        this.genre = genre;
        return this;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public Audiofile title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrack() {
        return this.track;
    }

    public Audiofile track(String track) {
        this.track = track;
        return this;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getTotal() {
        return this.total;
    }

    public Audiofile total(String total) {
        this.total = total;
        return this;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getYear() {
        return this.year;
    }

    public Audiofile year(String year) {
        this.year = year;
        return this;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFieldname() {
        return this.fieldname;
    }

    public Audiofile fieldname(String fieldname) {
        this.fieldname = fieldname;
        return this;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getBitrate() {
        return this.bitrate;
    }

    public Audiofile bitrate(String bitrate) {
        this.bitrate = bitrate;
        return this;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getBitspersample() {
        return this.bitspersample;
    }

    public Audiofile bitspersample(String bitspersample) {
        this.bitspersample = bitspersample;
        return this;
    }

    public void setBitspersample(String bitspersample) {
        this.bitspersample = bitspersample;
    }

    public String getCodec() {
        return this.codec;
    }

    public Audiofile codec(String codec) {
        this.codec = codec;
        return this;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public String getCovermimetype() {
        return this.covermimetype;
    }

    public Audiofile covermimetype(String covermimetype) {
        this.covermimetype = covermimetype;
        return this;
    }

    public void setCovermimetype(String covermimetype) {
        this.covermimetype = covermimetype;
    }

    public String getCoversize() {
        return this.coversize;
    }

    public Audiofile coversize(String coversize) {
        this.coversize = coversize;
        return this;
    }

    public void setCoversize(String coversize) {
        this.coversize = coversize;
    }

    public String getCovertype() {
        return this.covertype;
    }

    public Audiofile covertype(String covertype) {
        this.covertype = covertype;
        return this;
    }

    public void setCovertype(String covertype) {
        this.covertype = covertype;
    }

    public String getCoverheight() {
        return this.coverheight;
    }

    public Audiofile coverheight(String coverheight) {
        this.coverheight = coverheight;
        return this;
    }

    public void setCoverheight(String coverheight) {
        this.coverheight = coverheight;
    }

    public String getCoverwidth() {
        return this.coverwidth;
    }

    public Audiofile coverwidth(String coverwidth) {
        this.coverwidth = coverwidth;
        return this;
    }

    public void setCoverwidth(String coverwidth) {
        this.coverwidth = coverwidth;
    }

    public String getCovers() {
        return this.covers;
    }

    public Audiofile covers(String covers) {
        this.covers = covers;
        return this;
    }

    public void setCovers(String covers) {
        this.covers = covers;
    }

    public String getLengthseconds() {
        return this.lengthseconds;
    }

    public Audiofile lengthseconds(String lengthseconds) {
        this.lengthseconds = lengthseconds;
        return this;
    }

    public void setLengthseconds(String lengthseconds) {
        this.lengthseconds = lengthseconds;
    }

    public String getMode() {
        return this.mode;
    }

    public Audiofile mode(String mode) {
        this.mode = mode;
        return this;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getSamplerate() {
        return this.samplerate;
    }

    public Audiofile samplerate(String samplerate) {
        this.samplerate = samplerate;
        return this;
    }

    public void setSamplerate(String samplerate) {
        this.samplerate = samplerate;
    }

    public String getTool() {
        return this.tool;
    }

    public Audiofile tool(String tool) {
        this.tool = tool;
        return this;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getVbr() {
        return this.vbr;
    }

    public Audiofile vbr(String vbr) {
        this.vbr = vbr;
        return this;
    }

    public void setVbr(String vbr) {
        this.vbr = vbr;
    }

    public String getDirectory() {
        return this.directory;
    }

    public Audiofile directory(String directory) {
        this.directory = directory;
        return this;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getExtension() {
        return this.extension;
    }

    public Audiofile extension(String extension) {
        this.extension = extension;
        return this;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFilename() {
        return this.filename;
    }

    public Audiofile filename(String filename) {
        this.filename = filename;
        return this;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilenameext() {
        return this.filenameext;
    }

    public Audiofile filenameext(String filenameext) {
        this.filenameext = filenameext;
        return this;
    }

    public void setFilenameext(String filenameext) {
        this.filenameext = filenameext;
    }

    public String getFilenamerel() {
        return this.filenamerel;
    }

    public Audiofile filenamerel(String filenamerel) {
        this.filenamerel = filenamerel;
        return this;
    }

    public void setFilenamerel(String filenamerel) {
        this.filenamerel = filenamerel;
    }

    public String getFolderpath() {
        return this.folderpath;
    }

    public Audiofile folderpath(String folderpath) {
        this.folderpath = folderpath;
        return this;
    }

    public void setFolderpath(String folderpath) {
        this.folderpath = folderpath;
    }

    public String getFolderpathrel() {
        return this.folderpathrel;
    }

    public Audiofile folderpathrel(String folderpathrel) {
        this.folderpathrel = folderpathrel;
        return this;
    }

    public void setFolderpathrel(String folderpathrel) {
        this.folderpathrel = folderpathrel;
    }

    public String getParentdirectory() {
        return this.parentdirectory;
    }

    public Audiofile parentdirectory(String parentdirectory) {
        this.parentdirectory = parentdirectory;
        return this;
    }

    public void setParentdirectory(String parentdirectory) {
        this.parentdirectory = parentdirectory;
    }

    public String getPath() {
        return this.path;
    }

    public Audiofile path(String path) {
        this.path = path;
        return this;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVolume() {
        return this.volume;
    }

    public Audiofile volume(String volume) {
        this.volume = volume;
        return this;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getWorkingdir() {
        return this.workingdir;
    }

    public Audiofile workingdir(String workingdir) {
        this.workingdir = workingdir;
        return this;
    }

    public void setWorkingdir(String workingdir) {
        this.workingdir = workingdir;
    }

    public String getWorkingpath() {
        return this.workingpath;
    }

    public Audiofile workingpath(String workingpath) {
        this.workingpath = workingpath;
        return this;
    }

    public void setWorkingpath(String workingpath) {
        this.workingpath = workingpath;
    }

    public String getFilecreatedate() {
        return this.filecreatedate;
    }

    public Audiofile filecreatedate(String filecreatedate) {
        this.filecreatedate = filecreatedate;
        return this;
    }

    public void setFilecreatedate(String filecreatedate) {
        this.filecreatedate = filecreatedate;
    }

    public String getFilemoddate() {
        return this.filemoddate;
    }

    public Audiofile filemoddate(String filemoddate) {
        this.filemoddate = filemoddate;
        return this;
    }

    public void setFilemoddate(String filemoddate) {
        this.filemoddate = filemoddate;
    }

    public String getFilesizebytes() {
        return this.filesizebytes;
    }

    public Audiofile filesizebytes(String filesizebytes) {
        this.filesizebytes = filesizebytes;
        return this;
    }

    public void setFilesizebytes(String filesizebytes) {
        this.filesizebytes = filesizebytes;
    }

    public String getCrcVal() {
        return this.crcVal;
    }

    public Audiofile crcVal(String crcVal) {
        this.crcVal = crcVal;
        return this;
    }

    public void setCrcVal(String crcVal) {
        this.crcVal = crcVal;
    }

    public String getMd5Val() {
        return this.md5Val;
    }

    public Audiofile md5Val(String md5Val) {
        this.md5Val = md5Val;
        return this;
    }

    public void setMd5Val(String md5Val) {
        this.md5Val = md5Val;
    }

    public String getMd5audioVal() {
        return this.md5audioVal;
    }

    public Audiofile md5audioVal(String md5audioVal) {
        this.md5audioVal = md5audioVal;
        return this;
    }

    public void setMd5audioVal(String md5audioVal) {
        this.md5audioVal = md5audioVal;
    }

    public String getAppVal() {
        return this.appVal;
    }

    public Audiofile appVal(String appVal) {
        this.appVal = appVal;
        return this;
    }

    public void setAppVal(String appVal) {
        this.appVal = appVal;
    }

    public Device getDevice() {
        return this.device;
    }

    public Audiofile device(Device device) {
        this.setDevice(device);
        return this;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Audiofile)) {
            return false;
        }
        return id != null && id.equals(((Audiofile) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Audiofile{" +
            "id=" + getId() +
            ", artist='" + getArtist() + "'" +
            ", album='" + getAlbum() + "'" +
            ", comment='" + getComment() + "'" +
            ", genre='" + getGenre() + "'" +
            ", title='" + getTitle() + "'" +
            ", track='" + getTrack() + "'" +
            ", total='" + getTotal() + "'" +
            ", year='" + getYear() + "'" +
            ", fieldname='" + getFieldname() + "'" +
            ", bitrate='" + getBitrate() + "'" +
            ", bitspersample='" + getBitspersample() + "'" +
            ", codec='" + getCodec() + "'" +
            ", covermimetype='" + getCovermimetype() + "'" +
            ", coversize='" + getCoversize() + "'" +
            ", covertype='" + getCovertype() + "'" +
            ", coverheight='" + getCoverheight() + "'" +
            ", coverwidth='" + getCoverwidth() + "'" +
            ", covers='" + getCovers() + "'" +
            ", lengthseconds='" + getLengthseconds() + "'" +
            ", mode='" + getMode() + "'" +
            ", samplerate='" + getSamplerate() + "'" +
            ", tool='" + getTool() + "'" +
            ", vbr='" + getVbr() + "'" +
            ", directory='" + getDirectory() + "'" +
            ", extension='" + getExtension() + "'" +
            ", filename='" + getFilename() + "'" +
            ", filenameext='" + getFilenameext() + "'" +
            ", filenamerel='" + getFilenamerel() + "'" +
            ", folderpath='" + getFolderpath() + "'" +
            ", folderpathrel='" + getFolderpathrel() + "'" +
            ", parentdirectory='" + getParentdirectory() + "'" +
            ", path='" + getPath() + "'" +
            ", volume='" + getVolume() + "'" +
            ", workingdir='" + getWorkingdir() + "'" +
            ", workingpath='" + getWorkingpath() + "'" +
            ", filecreatedate='" + getFilecreatedate() + "'" +
            ", filemoddate='" + getFilemoddate() + "'" +
            ", filesizebytes='" + getFilesizebytes() + "'" +
            ", crcVal='" + getCrcVal() + "'" +
            ", md5Val='" + getMd5Val() + "'" +
            ", md5audioVal='" + getMd5audioVal() + "'" +
            ", appVal='" + getAppVal() + "'" +
            "}";
    }
}
