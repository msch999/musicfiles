package de.msch.web.rest;

import de.msch.domain.Audiofile;
import de.msch.repository.AudiofileRepository;
import de.msch.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link de.msch.domain.Audiofile}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class AudiofileResource {

    private final Logger log = LoggerFactory.getLogger(AudiofileResource.class);

    private static final String ENTITY_NAME = "audiofile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AudiofileRepository audiofileRepository;

    public AudiofileResource(AudiofileRepository audiofileRepository) {
        this.audiofileRepository = audiofileRepository;
    }

    /**
     * {@code POST  /audiofiles} : Create a new audiofile.
     *
     * @param audiofile the audiofile to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new audiofile, or with status {@code 400 (Bad Request)} if the audiofile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/audiofiles")
    public ResponseEntity<Audiofile> createAudiofile(@Valid @RequestBody Audiofile audiofile) throws URISyntaxException {
        log.debug("REST request to save Audiofile : {}", audiofile);
        if (audiofile.getId() != null) {
            throw new BadRequestAlertException("A new audiofile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Audiofile result = audiofileRepository.save(audiofile);
        return ResponseEntity
            .created(new URI("/api/audiofiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /audiofiles} : Updates an existing audiofile.
     *
     * @param audiofile the audiofile to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated audiofile,
     * or with status {@code 400 (Bad Request)} if the audiofile is not valid,
     * or with status {@code 500 (Internal Server Error)} if the audiofile couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/audiofiles")
    public ResponseEntity<Audiofile> updateAudiofile(@Valid @RequestBody Audiofile audiofile) throws URISyntaxException {
        log.debug("REST request to update Audiofile : {}", audiofile);
        if (audiofile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Audiofile result = audiofileRepository.save(audiofile);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, audiofile.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /audiofiles} : Updates given fields of an existing audiofile.
     *
     * @param audiofile the audiofile to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated audiofile,
     * or with status {@code 400 (Bad Request)} if the audiofile is not valid,
     * or with status {@code 404 (Not Found)} if the audiofile is not found,
     * or with status {@code 500 (Internal Server Error)} if the audiofile couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/audiofiles", consumes = "application/merge-patch+json")
    public ResponseEntity<Audiofile> partialUpdateAudiofile(@NotNull @RequestBody Audiofile audiofile) throws URISyntaxException {
        log.debug("REST request to update Audiofile partially : {}", audiofile);
        if (audiofile.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }

        Optional<Audiofile> result = audiofileRepository
            .findById(audiofile.getId())
            .map(
                existingAudiofile -> {
                    if (audiofile.getArtist() != null) {
                        existingAudiofile.setArtist(audiofile.getArtist());
                    }

                    if (audiofile.getAlbum() != null) {
                        existingAudiofile.setAlbum(audiofile.getAlbum());
                    }

                    if (audiofile.getComment() != null) {
                        existingAudiofile.setComment(audiofile.getComment());
                    }

                    if (audiofile.getGenre() != null) {
                        existingAudiofile.setGenre(audiofile.getGenre());
                    }

                    if (audiofile.getTitle() != null) {
                        existingAudiofile.setTitle(audiofile.getTitle());
                    }

                    if (audiofile.getTrack() != null) {
                        existingAudiofile.setTrack(audiofile.getTrack());
                    }

                    if (audiofile.getTotal() != null) {
                        existingAudiofile.setTotal(audiofile.getTotal());
                    }

                    if (audiofile.getYear() != null) {
                        existingAudiofile.setYear(audiofile.getYear());
                    }

                    if (audiofile.getFieldname() != null) {
                        existingAudiofile.setFieldname(audiofile.getFieldname());
                    }

                    if (audiofile.getBitrate() != null) {
                        existingAudiofile.setBitrate(audiofile.getBitrate());
                    }

                    if (audiofile.getBitspersample() != null) {
                        existingAudiofile.setBitspersample(audiofile.getBitspersample());
                    }

                    if (audiofile.getCodec() != null) {
                        existingAudiofile.setCodec(audiofile.getCodec());
                    }

                    if (audiofile.getCovermimetype() != null) {
                        existingAudiofile.setCovermimetype(audiofile.getCovermimetype());
                    }

                    if (audiofile.getCoversize() != null) {
                        existingAudiofile.setCoversize(audiofile.getCoversize());
                    }

                    if (audiofile.getCovertype() != null) {
                        existingAudiofile.setCovertype(audiofile.getCovertype());
                    }

                    if (audiofile.getCoverheight() != null) {
                        existingAudiofile.setCoverheight(audiofile.getCoverheight());
                    }

                    if (audiofile.getCoverwidth() != null) {
                        existingAudiofile.setCoverwidth(audiofile.getCoverwidth());
                    }

                    if (audiofile.getCovers() != null) {
                        existingAudiofile.setCovers(audiofile.getCovers());
                    }

                    if (audiofile.getLengthseconds() != null) {
                        existingAudiofile.setLengthseconds(audiofile.getLengthseconds());
                    }

                    if (audiofile.getMode() != null) {
                        existingAudiofile.setMode(audiofile.getMode());
                    }

                    if (audiofile.getSamplerate() != null) {
                        existingAudiofile.setSamplerate(audiofile.getSamplerate());
                    }

                    if (audiofile.getTool() != null) {
                        existingAudiofile.setTool(audiofile.getTool());
                    }

                    if (audiofile.getVbr() != null) {
                        existingAudiofile.setVbr(audiofile.getVbr());
                    }

                    if (audiofile.getDirectory() != null) {
                        existingAudiofile.setDirectory(audiofile.getDirectory());
                    }

                    if (audiofile.getExtension() != null) {
                        existingAudiofile.setExtension(audiofile.getExtension());
                    }

                    if (audiofile.getFilename() != null) {
                        existingAudiofile.setFilename(audiofile.getFilename());
                    }

                    if (audiofile.getFilenameext() != null) {
                        existingAudiofile.setFilenameext(audiofile.getFilenameext());
                    }

                    if (audiofile.getFilenamerel() != null) {
                        existingAudiofile.setFilenamerel(audiofile.getFilenamerel());
                    }

                    if (audiofile.getFolderpath() != null) {
                        existingAudiofile.setFolderpath(audiofile.getFolderpath());
                    }

                    if (audiofile.getFolderpathrel() != null) {
                        existingAudiofile.setFolderpathrel(audiofile.getFolderpathrel());
                    }

                    if (audiofile.getParentdirectory() != null) {
                        existingAudiofile.setParentdirectory(audiofile.getParentdirectory());
                    }

                    if (audiofile.getPath() != null) {
                        existingAudiofile.setPath(audiofile.getPath());
                    }

                    if (audiofile.getVolume() != null) {
                        existingAudiofile.setVolume(audiofile.getVolume());
                    }

                    if (audiofile.getWorkingdir() != null) {
                        existingAudiofile.setWorkingdir(audiofile.getWorkingdir());
                    }

                    if (audiofile.getWorkingpath() != null) {
                        existingAudiofile.setWorkingpath(audiofile.getWorkingpath());
                    }

                    if (audiofile.getFilecreatedate() != null) {
                        existingAudiofile.setFilecreatedate(audiofile.getFilecreatedate());
                    }

                    if (audiofile.getFilemoddate() != null) {
                        existingAudiofile.setFilemoddate(audiofile.getFilemoddate());
                    }

                    if (audiofile.getFilesizebytes() != null) {
                        existingAudiofile.setFilesizebytes(audiofile.getFilesizebytes());
                    }

                    if (audiofile.getCrcVal() != null) {
                        existingAudiofile.setCrcVal(audiofile.getCrcVal());
                    }

                    if (audiofile.getMd5Val() != null) {
                        existingAudiofile.setMd5Val(audiofile.getMd5Val());
                    }

                    if (audiofile.getMd5audioVal() != null) {
                        existingAudiofile.setMd5audioVal(audiofile.getMd5audioVal());
                    }

                    if (audiofile.getAppVal() != null) {
                        existingAudiofile.setAppVal(audiofile.getAppVal());
                    }

                    return existingAudiofile;
                }
            )
            .map(audiofileRepository::save);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, audiofile.getId().toString())
        );
    }

    /**
     * {@code GET  /audiofiles} : get all the audiofiles.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of audiofiles in body.
     */
    @GetMapping("/audiofiles")
    public List<Audiofile> getAllAudiofiles() {
        log.debug("REST request to get all Audiofiles");
        return audiofileRepository.findAll();
    }

    /**
     * {@code GET  /audiofiles/:id} : get the "id" audiofile.
     *
     * @param id the id of the audiofile to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the audiofile, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/audiofiles/{id}")
    public ResponseEntity<Audiofile> getAudiofile(@PathVariable Long id) {
        log.debug("REST request to get Audiofile : {}", id);
        Optional<Audiofile> audiofile = audiofileRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(audiofile);
    }

    /**
     * {@code DELETE  /audiofiles/:id} : delete the "id" audiofile.
     *
     * @param id the id of the audiofile to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/audiofiles/{id}")
    public ResponseEntity<Void> deleteAudiofile(@PathVariable Long id) {
        log.debug("REST request to delete Audiofile : {}", id);
        audiofileRepository.deleteById(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
