package de.msch.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import de.msch.IntegrationTest;
import de.msch.domain.Audiofile;
import de.msch.repository.AudiofileRepository;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link AudiofileResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class AudiofileResourceIT {

    private static final String DEFAULT_ARTIST = "AAAAAAAAAA";
    private static final String UPDATED_ARTIST = "BBBBBBBBBB";

    private static final String DEFAULT_ALBUM = "AAAAAAAAAA";
    private static final String UPDATED_ALBUM = "BBBBBBBBBB";

    private static final String DEFAULT_COMMENT = "AAAAAAAAAA";
    private static final String UPDATED_COMMENT = "BBBBBBBBBB";

    private static final String DEFAULT_GENRE = "AAAAAAAAAA";
    private static final String UPDATED_GENRE = "BBBBBBBBBB";

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_TRACK = "AAAAAAAAAA";
    private static final String UPDATED_TRACK = "BBBBBBBBBB";

    private static final String DEFAULT_TOTAL = "AAAAAAAAAA";
    private static final String UPDATED_TOTAL = "BBBBBBBBBB";

    private static final String DEFAULT_YEAR = "AAAAAAAAAA";
    private static final String UPDATED_YEAR = "BBBBBBBBBB";

    private static final String DEFAULT_FIELDNAME = "AAAAAAAAAA";
    private static final String UPDATED_FIELDNAME = "BBBBBBBBBB";

    private static final String DEFAULT_BITRATE = "AAAAAAAAAA";
    private static final String UPDATED_BITRATE = "BBBBBBBBBB";

    private static final String DEFAULT_BITSPERSAMPLE = "AAAAAAAAAA";
    private static final String UPDATED_BITSPERSAMPLE = "BBBBBBBBBB";

    private static final String DEFAULT_CODEC = "AAAAAAAAAA";
    private static final String UPDATED_CODEC = "BBBBBBBBBB";

    private static final String DEFAULT_COVERMIMETYPE = "AAAAAAAAAA";
    private static final String UPDATED_COVERMIMETYPE = "BBBBBBBBBB";

    private static final String DEFAULT_COVERSIZE = "AAAAAAAAAA";
    private static final String UPDATED_COVERSIZE = "BBBBBBBBBB";

    private static final String DEFAULT_COVERTYPE = "AAAAAAAAAA";
    private static final String UPDATED_COVERTYPE = "BBBBBBBBBB";

    private static final String DEFAULT_COVERHEIGHT = "AAAAAAAAAA";
    private static final String UPDATED_COVERHEIGHT = "BBBBBBBBBB";

    private static final String DEFAULT_COVERWIDTH = "AAAAAAAAAA";
    private static final String UPDATED_COVERWIDTH = "BBBBBBBBBB";

    private static final String DEFAULT_COVERS = "AAAAAAAAAA";
    private static final String UPDATED_COVERS = "BBBBBBBBBB";

    private static final String DEFAULT_LENGTHSECONDS = "AAAAAAAAAA";
    private static final String UPDATED_LENGTHSECONDS = "BBBBBBBBBB";

    private static final String DEFAULT_MODE = "AAAAAAAAAA";
    private static final String UPDATED_MODE = "BBBBBBBBBB";

    private static final String DEFAULT_SAMPLERATE = "AAAAAAAAAA";
    private static final String UPDATED_SAMPLERATE = "BBBBBBBBBB";

    private static final String DEFAULT_TOOL = "AAAAAAAAAA";
    private static final String UPDATED_TOOL = "BBBBBBBBBB";

    private static final String DEFAULT_VBR = "AAAAAAAAAA";
    private static final String UPDATED_VBR = "BBBBBBBBBB";

    private static final String DEFAULT_DIRECTORY = "AAAAAAAAAA";
    private static final String UPDATED_DIRECTORY = "BBBBBBBBBB";

    private static final String DEFAULT_EXTENSION = "AAAAAAAAAA";
    private static final String UPDATED_EXTENSION = "BBBBBBBBBB";

    private static final String DEFAULT_FILENAME = "AAAAAAAAAA";
    private static final String UPDATED_FILENAME = "BBBBBBBBBB";

    private static final String DEFAULT_FILENAMEEXT = "AAAAAAAAAA";
    private static final String UPDATED_FILENAMEEXT = "BBBBBBBBBB";

    private static final String DEFAULT_FILENAMEREL = "AAAAAAAAAA";
    private static final String UPDATED_FILENAMEREL = "BBBBBBBBBB";

    private static final String DEFAULT_FOLDERPATH = "AAAAAAAAAA";
    private static final String UPDATED_FOLDERPATH = "BBBBBBBBBB";

    private static final String DEFAULT_FOLDERPATHREL = "AAAAAAAAAA";
    private static final String UPDATED_FOLDERPATHREL = "BBBBBBBBBB";

    private static final String DEFAULT_PARENTDIRECTORY = "AAAAAAAAAA";
    private static final String UPDATED_PARENTDIRECTORY = "BBBBBBBBBB";

    private static final String DEFAULT_PATH = "AAAAAAAAAA";
    private static final String UPDATED_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_VOLUME = "AAAAAAAAAA";
    private static final String UPDATED_VOLUME = "BBBBBBBBBB";

    private static final String DEFAULT_WORKINGDIR = "AAAAAAAAAA";
    private static final String UPDATED_WORKINGDIR = "BBBBBBBBBB";

    private static final String DEFAULT_WORKINGPATH = "AAAAAAAAAA";
    private static final String UPDATED_WORKINGPATH = "BBBBBBBBBB";

    private static final String DEFAULT_FILECREATEDATE = "AAAAAAAAAA";
    private static final String UPDATED_FILECREATEDATE = "BBBBBBBBBB";

    private static final String DEFAULT_FILEMODDATE = "AAAAAAAAAA";
    private static final String UPDATED_FILEMODDATE = "BBBBBBBBBB";

    private static final String DEFAULT_FILESIZEBYTES = "AAAAAAAAAA";
    private static final String UPDATED_FILESIZEBYTES = "BBBBBBBBBB";

    private static final String DEFAULT_CRC_VAL = "AAAAAAAAAA";
    private static final String UPDATED_CRC_VAL = "BBBBBBBBBB";

    private static final String DEFAULT_MD_5_VAL = "AAAAAAAAAA";
    private static final String UPDATED_MD_5_VAL = "BBBBBBBBBB";

    private static final String DEFAULT_MD_5_AUDIO_VAL = "AAAAAAAAAA";
    private static final String UPDATED_MD_5_AUDIO_VAL = "BBBBBBBBBB";

    private static final String DEFAULT_APP_VAL = "AAAAAAAAAA";
    private static final String UPDATED_APP_VAL = "BBBBBBBBBB";

    @Autowired
    private AudiofileRepository audiofileRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAudiofileMockMvc;

    private Audiofile audiofile;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Audiofile createEntity(EntityManager em) {
        Audiofile audiofile = new Audiofile()
            .artist(DEFAULT_ARTIST)
            .album(DEFAULT_ALBUM)
            .comment(DEFAULT_COMMENT)
            .genre(DEFAULT_GENRE)
            .title(DEFAULT_TITLE)
            .track(DEFAULT_TRACK)
            .total(DEFAULT_TOTAL)
            .year(DEFAULT_YEAR)
            .fieldname(DEFAULT_FIELDNAME)
            .bitrate(DEFAULT_BITRATE)
            .bitspersample(DEFAULT_BITSPERSAMPLE)
            .codec(DEFAULT_CODEC)
            .covermimetype(DEFAULT_COVERMIMETYPE)
            .coversize(DEFAULT_COVERSIZE)
            .covertype(DEFAULT_COVERTYPE)
            .coverheight(DEFAULT_COVERHEIGHT)
            .coverwidth(DEFAULT_COVERWIDTH)
            .covers(DEFAULT_COVERS)
            .lengthseconds(DEFAULT_LENGTHSECONDS)
            .mode(DEFAULT_MODE)
            .samplerate(DEFAULT_SAMPLERATE)
            .tool(DEFAULT_TOOL)
            .vbr(DEFAULT_VBR)
            .directory(DEFAULT_DIRECTORY)
            .extension(DEFAULT_EXTENSION)
            .filename(DEFAULT_FILENAME)
            .filenameext(DEFAULT_FILENAMEEXT)
            .filenamerel(DEFAULT_FILENAMEREL)
            .folderpath(DEFAULT_FOLDERPATH)
            .folderpathrel(DEFAULT_FOLDERPATHREL)
            .parentdirectory(DEFAULT_PARENTDIRECTORY)
            .path(DEFAULT_PATH)
            .volume(DEFAULT_VOLUME)
            .workingdir(DEFAULT_WORKINGDIR)
            .workingpath(DEFAULT_WORKINGPATH)
            .filecreatedate(DEFAULT_FILECREATEDATE)
            .filemoddate(DEFAULT_FILEMODDATE)
            .filesizebytes(DEFAULT_FILESIZEBYTES)
            .crcVal(DEFAULT_CRC_VAL)
            .md5Val(DEFAULT_MD_5_VAL)
            .md5audioVal(DEFAULT_MD_5_AUDIO_VAL)
            .appVal(DEFAULT_APP_VAL);
        return audiofile;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Audiofile createUpdatedEntity(EntityManager em) {
        Audiofile audiofile = new Audiofile()
            .artist(UPDATED_ARTIST)
            .album(UPDATED_ALBUM)
            .comment(UPDATED_COMMENT)
            .genre(UPDATED_GENRE)
            .title(UPDATED_TITLE)
            .track(UPDATED_TRACK)
            .total(UPDATED_TOTAL)
            .year(UPDATED_YEAR)
            .fieldname(UPDATED_FIELDNAME)
            .bitrate(UPDATED_BITRATE)
            .bitspersample(UPDATED_BITSPERSAMPLE)
            .codec(UPDATED_CODEC)
            .covermimetype(UPDATED_COVERMIMETYPE)
            .coversize(UPDATED_COVERSIZE)
            .covertype(UPDATED_COVERTYPE)
            .coverheight(UPDATED_COVERHEIGHT)
            .coverwidth(UPDATED_COVERWIDTH)
            .covers(UPDATED_COVERS)
            .lengthseconds(UPDATED_LENGTHSECONDS)
            .mode(UPDATED_MODE)
            .samplerate(UPDATED_SAMPLERATE)
            .tool(UPDATED_TOOL)
            .vbr(UPDATED_VBR)
            .directory(UPDATED_DIRECTORY)
            .extension(UPDATED_EXTENSION)
            .filename(UPDATED_FILENAME)
            .filenameext(UPDATED_FILENAMEEXT)
            .filenamerel(UPDATED_FILENAMEREL)
            .folderpath(UPDATED_FOLDERPATH)
            .folderpathrel(UPDATED_FOLDERPATHREL)
            .parentdirectory(UPDATED_PARENTDIRECTORY)
            .path(UPDATED_PATH)
            .volume(UPDATED_VOLUME)
            .workingdir(UPDATED_WORKINGDIR)
            .workingpath(UPDATED_WORKINGPATH)
            .filecreatedate(UPDATED_FILECREATEDATE)
            .filemoddate(UPDATED_FILEMODDATE)
            .filesizebytes(UPDATED_FILESIZEBYTES)
            .crcVal(UPDATED_CRC_VAL)
            .md5Val(UPDATED_MD_5_VAL)
            .md5audioVal(UPDATED_MD_5_AUDIO_VAL)
            .appVal(UPDATED_APP_VAL);
        return audiofile;
    }

    @BeforeEach
    public void initTest() {
        audiofile = createEntity(em);
    }

    @Test
    @Transactional
    void createAudiofile() throws Exception {
        int databaseSizeBeforeCreate = audiofileRepository.findAll().size();
        // Create the Audiofile
        restAudiofileMockMvc
            .perform(post("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(audiofile)))
            .andExpect(status().isCreated());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeCreate + 1);
        Audiofile testAudiofile = audiofileList.get(audiofileList.size() - 1);
        assertThat(testAudiofile.getArtist()).isEqualTo(DEFAULT_ARTIST);
        assertThat(testAudiofile.getAlbum()).isEqualTo(DEFAULT_ALBUM);
        assertThat(testAudiofile.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testAudiofile.getGenre()).isEqualTo(DEFAULT_GENRE);
        assertThat(testAudiofile.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testAudiofile.getTrack()).isEqualTo(DEFAULT_TRACK);
        assertThat(testAudiofile.getTotal()).isEqualTo(DEFAULT_TOTAL);
        assertThat(testAudiofile.getYear()).isEqualTo(DEFAULT_YEAR);
        assertThat(testAudiofile.getFieldname()).isEqualTo(DEFAULT_FIELDNAME);
        assertThat(testAudiofile.getBitrate()).isEqualTo(DEFAULT_BITRATE);
        assertThat(testAudiofile.getBitspersample()).isEqualTo(DEFAULT_BITSPERSAMPLE);
        assertThat(testAudiofile.getCodec()).isEqualTo(DEFAULT_CODEC);
        assertThat(testAudiofile.getCovermimetype()).isEqualTo(DEFAULT_COVERMIMETYPE);
        assertThat(testAudiofile.getCoversize()).isEqualTo(DEFAULT_COVERSIZE);
        assertThat(testAudiofile.getCovertype()).isEqualTo(DEFAULT_COVERTYPE);
        assertThat(testAudiofile.getCoverheight()).isEqualTo(DEFAULT_COVERHEIGHT);
        assertThat(testAudiofile.getCoverwidth()).isEqualTo(DEFAULT_COVERWIDTH);
        assertThat(testAudiofile.getCovers()).isEqualTo(DEFAULT_COVERS);
        assertThat(testAudiofile.getLengthseconds()).isEqualTo(DEFAULT_LENGTHSECONDS);
        assertThat(testAudiofile.getMode()).isEqualTo(DEFAULT_MODE);
        assertThat(testAudiofile.getSamplerate()).isEqualTo(DEFAULT_SAMPLERATE);
        assertThat(testAudiofile.getTool()).isEqualTo(DEFAULT_TOOL);
        assertThat(testAudiofile.getVbr()).isEqualTo(DEFAULT_VBR);
        assertThat(testAudiofile.getDirectory()).isEqualTo(DEFAULT_DIRECTORY);
        assertThat(testAudiofile.getExtension()).isEqualTo(DEFAULT_EXTENSION);
        assertThat(testAudiofile.getFilename()).isEqualTo(DEFAULT_FILENAME);
        assertThat(testAudiofile.getFilenameext()).isEqualTo(DEFAULT_FILENAMEEXT);
        assertThat(testAudiofile.getFilenamerel()).isEqualTo(DEFAULT_FILENAMEREL);
        assertThat(testAudiofile.getFolderpath()).isEqualTo(DEFAULT_FOLDERPATH);
        assertThat(testAudiofile.getFolderpathrel()).isEqualTo(DEFAULT_FOLDERPATHREL);
        assertThat(testAudiofile.getParentdirectory()).isEqualTo(DEFAULT_PARENTDIRECTORY);
        assertThat(testAudiofile.getPath()).isEqualTo(DEFAULT_PATH);
        assertThat(testAudiofile.getVolume()).isEqualTo(DEFAULT_VOLUME);
        assertThat(testAudiofile.getWorkingdir()).isEqualTo(DEFAULT_WORKINGDIR);
        assertThat(testAudiofile.getWorkingpath()).isEqualTo(DEFAULT_WORKINGPATH);
        assertThat(testAudiofile.getFilecreatedate()).isEqualTo(DEFAULT_FILECREATEDATE);
        assertThat(testAudiofile.getFilemoddate()).isEqualTo(DEFAULT_FILEMODDATE);
        assertThat(testAudiofile.getFilesizebytes()).isEqualTo(DEFAULT_FILESIZEBYTES);
        assertThat(testAudiofile.getCrcVal()).isEqualTo(DEFAULT_CRC_VAL);
        assertThat(testAudiofile.getMd5Val()).isEqualTo(DEFAULT_MD_5_VAL);
        assertThat(testAudiofile.getMd5audioVal()).isEqualTo(DEFAULT_MD_5_AUDIO_VAL);
        assertThat(testAudiofile.getAppVal()).isEqualTo(DEFAULT_APP_VAL);
    }

    @Test
    @Transactional
    void createAudiofileWithExistingId() throws Exception {
        // Create the Audiofile with an existing ID
        audiofile.setId(1L);

        int databaseSizeBeforeCreate = audiofileRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restAudiofileMockMvc
            .perform(post("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(audiofile)))
            .andExpect(status().isBadRequest());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void checkArtistIsRequired() throws Exception {
        int databaseSizeBeforeTest = audiofileRepository.findAll().size();
        // set the field null
        audiofile.setArtist(null);

        // Create the Audiofile, which fails.

        restAudiofileMockMvc
            .perform(post("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(audiofile)))
            .andExpect(status().isBadRequest());

        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void checkTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = audiofileRepository.findAll().size();
        // set the field null
        audiofile.setTitle(null);

        // Create the Audiofile, which fails.

        restAudiofileMockMvc
            .perform(post("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(audiofile)))
            .andExpect(status().isBadRequest());

        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    void getAllAudiofiles() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        // Get all the audiofileList
        restAudiofileMockMvc
            .perform(get("/api/audiofiles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(audiofile.getId().intValue())))
            .andExpect(jsonPath("$.[*].artist").value(hasItem(DEFAULT_ARTIST)))
            .andExpect(jsonPath("$.[*].album").value(hasItem(DEFAULT_ALBUM)))
            .andExpect(jsonPath("$.[*].comment").value(hasItem(DEFAULT_COMMENT)))
            .andExpect(jsonPath("$.[*].genre").value(hasItem(DEFAULT_GENRE)))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].track").value(hasItem(DEFAULT_TRACK)))
            .andExpect(jsonPath("$.[*].total").value(hasItem(DEFAULT_TOTAL)))
            .andExpect(jsonPath("$.[*].year").value(hasItem(DEFAULT_YEAR)))
            .andExpect(jsonPath("$.[*].fieldname").value(hasItem(DEFAULT_FIELDNAME)))
            .andExpect(jsonPath("$.[*].bitrate").value(hasItem(DEFAULT_BITRATE)))
            .andExpect(jsonPath("$.[*].bitspersample").value(hasItem(DEFAULT_BITSPERSAMPLE)))
            .andExpect(jsonPath("$.[*].codec").value(hasItem(DEFAULT_CODEC)))
            .andExpect(jsonPath("$.[*].covermimetype").value(hasItem(DEFAULT_COVERMIMETYPE)))
            .andExpect(jsonPath("$.[*].coversize").value(hasItem(DEFAULT_COVERSIZE)))
            .andExpect(jsonPath("$.[*].covertype").value(hasItem(DEFAULT_COVERTYPE)))
            .andExpect(jsonPath("$.[*].coverheight").value(hasItem(DEFAULT_COVERHEIGHT)))
            .andExpect(jsonPath("$.[*].coverwidth").value(hasItem(DEFAULT_COVERWIDTH)))
            .andExpect(jsonPath("$.[*].covers").value(hasItem(DEFAULT_COVERS)))
            .andExpect(jsonPath("$.[*].lengthseconds").value(hasItem(DEFAULT_LENGTHSECONDS)))
            .andExpect(jsonPath("$.[*].mode").value(hasItem(DEFAULT_MODE)))
            .andExpect(jsonPath("$.[*].samplerate").value(hasItem(DEFAULT_SAMPLERATE)))
            .andExpect(jsonPath("$.[*].tool").value(hasItem(DEFAULT_TOOL)))
            .andExpect(jsonPath("$.[*].vbr").value(hasItem(DEFAULT_VBR)))
            .andExpect(jsonPath("$.[*].directory").value(hasItem(DEFAULT_DIRECTORY)))
            .andExpect(jsonPath("$.[*].extension").value(hasItem(DEFAULT_EXTENSION)))
            .andExpect(jsonPath("$.[*].filename").value(hasItem(DEFAULT_FILENAME)))
            .andExpect(jsonPath("$.[*].filenameext").value(hasItem(DEFAULT_FILENAMEEXT)))
            .andExpect(jsonPath("$.[*].filenamerel").value(hasItem(DEFAULT_FILENAMEREL)))
            .andExpect(jsonPath("$.[*].folderpath").value(hasItem(DEFAULT_FOLDERPATH)))
            .andExpect(jsonPath("$.[*].folderpathrel").value(hasItem(DEFAULT_FOLDERPATHREL)))
            .andExpect(jsonPath("$.[*].parentdirectory").value(hasItem(DEFAULT_PARENTDIRECTORY)))
            .andExpect(jsonPath("$.[*].path").value(hasItem(DEFAULT_PATH)))
            .andExpect(jsonPath("$.[*].volume").value(hasItem(DEFAULT_VOLUME)))
            .andExpect(jsonPath("$.[*].workingdir").value(hasItem(DEFAULT_WORKINGDIR)))
            .andExpect(jsonPath("$.[*].workingpath").value(hasItem(DEFAULT_WORKINGPATH)))
            .andExpect(jsonPath("$.[*].filecreatedate").value(hasItem(DEFAULT_FILECREATEDATE)))
            .andExpect(jsonPath("$.[*].filemoddate").value(hasItem(DEFAULT_FILEMODDATE)))
            .andExpect(jsonPath("$.[*].filesizebytes").value(hasItem(DEFAULT_FILESIZEBYTES)))
            .andExpect(jsonPath("$.[*].crcVal").value(hasItem(DEFAULT_CRC_VAL)))
            .andExpect(jsonPath("$.[*].md5Val").value(hasItem(DEFAULT_MD_5_VAL)))
            .andExpect(jsonPath("$.[*].md5audioVal").value(hasItem(DEFAULT_MD_5_AUDIO_VAL)))
            .andExpect(jsonPath("$.[*].appVal").value(hasItem(DEFAULT_APP_VAL)));
    }

    @Test
    @Transactional
    void getAudiofile() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        // Get the audiofile
        restAudiofileMockMvc
            .perform(get("/api/audiofiles/{id}", audiofile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(audiofile.getId().intValue()))
            .andExpect(jsonPath("$.artist").value(DEFAULT_ARTIST))
            .andExpect(jsonPath("$.album").value(DEFAULT_ALBUM))
            .andExpect(jsonPath("$.comment").value(DEFAULT_COMMENT))
            .andExpect(jsonPath("$.genre").value(DEFAULT_GENRE))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.track").value(DEFAULT_TRACK))
            .andExpect(jsonPath("$.total").value(DEFAULT_TOTAL))
            .andExpect(jsonPath("$.year").value(DEFAULT_YEAR))
            .andExpect(jsonPath("$.fieldname").value(DEFAULT_FIELDNAME))
            .andExpect(jsonPath("$.bitrate").value(DEFAULT_BITRATE))
            .andExpect(jsonPath("$.bitspersample").value(DEFAULT_BITSPERSAMPLE))
            .andExpect(jsonPath("$.codec").value(DEFAULT_CODEC))
            .andExpect(jsonPath("$.covermimetype").value(DEFAULT_COVERMIMETYPE))
            .andExpect(jsonPath("$.coversize").value(DEFAULT_COVERSIZE))
            .andExpect(jsonPath("$.covertype").value(DEFAULT_COVERTYPE))
            .andExpect(jsonPath("$.coverheight").value(DEFAULT_COVERHEIGHT))
            .andExpect(jsonPath("$.coverwidth").value(DEFAULT_COVERWIDTH))
            .andExpect(jsonPath("$.covers").value(DEFAULT_COVERS))
            .andExpect(jsonPath("$.lengthseconds").value(DEFAULT_LENGTHSECONDS))
            .andExpect(jsonPath("$.mode").value(DEFAULT_MODE))
            .andExpect(jsonPath("$.samplerate").value(DEFAULT_SAMPLERATE))
            .andExpect(jsonPath("$.tool").value(DEFAULT_TOOL))
            .andExpect(jsonPath("$.vbr").value(DEFAULT_VBR))
            .andExpect(jsonPath("$.directory").value(DEFAULT_DIRECTORY))
            .andExpect(jsonPath("$.extension").value(DEFAULT_EXTENSION))
            .andExpect(jsonPath("$.filename").value(DEFAULT_FILENAME))
            .andExpect(jsonPath("$.filenameext").value(DEFAULT_FILENAMEEXT))
            .andExpect(jsonPath("$.filenamerel").value(DEFAULT_FILENAMEREL))
            .andExpect(jsonPath("$.folderpath").value(DEFAULT_FOLDERPATH))
            .andExpect(jsonPath("$.folderpathrel").value(DEFAULT_FOLDERPATHREL))
            .andExpect(jsonPath("$.parentdirectory").value(DEFAULT_PARENTDIRECTORY))
            .andExpect(jsonPath("$.path").value(DEFAULT_PATH))
            .andExpect(jsonPath("$.volume").value(DEFAULT_VOLUME))
            .andExpect(jsonPath("$.workingdir").value(DEFAULT_WORKINGDIR))
            .andExpect(jsonPath("$.workingpath").value(DEFAULT_WORKINGPATH))
            .andExpect(jsonPath("$.filecreatedate").value(DEFAULT_FILECREATEDATE))
            .andExpect(jsonPath("$.filemoddate").value(DEFAULT_FILEMODDATE))
            .andExpect(jsonPath("$.filesizebytes").value(DEFAULT_FILESIZEBYTES))
            .andExpect(jsonPath("$.crcVal").value(DEFAULT_CRC_VAL))
            .andExpect(jsonPath("$.md5Val").value(DEFAULT_MD_5_VAL))
            .andExpect(jsonPath("$.md5audioVal").value(DEFAULT_MD_5_AUDIO_VAL))
            .andExpect(jsonPath("$.appVal").value(DEFAULT_APP_VAL));
    }

    @Test
    @Transactional
    void getNonExistingAudiofile() throws Exception {
        // Get the audiofile
        restAudiofileMockMvc.perform(get("/api/audiofiles/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void updateAudiofile() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        int databaseSizeBeforeUpdate = audiofileRepository.findAll().size();

        // Update the audiofile
        Audiofile updatedAudiofile = audiofileRepository.findById(audiofile.getId()).get();
        // Disconnect from session so that the updates on updatedAudiofile are not directly saved in db
        em.detach(updatedAudiofile);
        updatedAudiofile
            .artist(UPDATED_ARTIST)
            .album(UPDATED_ALBUM)
            .comment(UPDATED_COMMENT)
            .genre(UPDATED_GENRE)
            .title(UPDATED_TITLE)
            .track(UPDATED_TRACK)
            .total(UPDATED_TOTAL)
            .year(UPDATED_YEAR)
            .fieldname(UPDATED_FIELDNAME)
            .bitrate(UPDATED_BITRATE)
            .bitspersample(UPDATED_BITSPERSAMPLE)
            .codec(UPDATED_CODEC)
            .covermimetype(UPDATED_COVERMIMETYPE)
            .coversize(UPDATED_COVERSIZE)
            .covertype(UPDATED_COVERTYPE)
            .coverheight(UPDATED_COVERHEIGHT)
            .coverwidth(UPDATED_COVERWIDTH)
            .covers(UPDATED_COVERS)
            .lengthseconds(UPDATED_LENGTHSECONDS)
            .mode(UPDATED_MODE)
            .samplerate(UPDATED_SAMPLERATE)
            .tool(UPDATED_TOOL)
            .vbr(UPDATED_VBR)
            .directory(UPDATED_DIRECTORY)
            .extension(UPDATED_EXTENSION)
            .filename(UPDATED_FILENAME)
            .filenameext(UPDATED_FILENAMEEXT)
            .filenamerel(UPDATED_FILENAMEREL)
            .folderpath(UPDATED_FOLDERPATH)
            .folderpathrel(UPDATED_FOLDERPATHREL)
            .parentdirectory(UPDATED_PARENTDIRECTORY)
            .path(UPDATED_PATH)
            .volume(UPDATED_VOLUME)
            .workingdir(UPDATED_WORKINGDIR)
            .workingpath(UPDATED_WORKINGPATH)
            .filecreatedate(UPDATED_FILECREATEDATE)
            .filemoddate(UPDATED_FILEMODDATE)
            .filesizebytes(UPDATED_FILESIZEBYTES)
            .crcVal(UPDATED_CRC_VAL)
            .md5Val(UPDATED_MD_5_VAL)
            .md5audioVal(UPDATED_MD_5_AUDIO_VAL)
            .appVal(UPDATED_APP_VAL);

        restAudiofileMockMvc
            .perform(
                put("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(updatedAudiofile))
            )
            .andExpect(status().isOk());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeUpdate);
        Audiofile testAudiofile = audiofileList.get(audiofileList.size() - 1);
        assertThat(testAudiofile.getArtist()).isEqualTo(UPDATED_ARTIST);
        assertThat(testAudiofile.getAlbum()).isEqualTo(UPDATED_ALBUM);
        assertThat(testAudiofile.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testAudiofile.getGenre()).isEqualTo(UPDATED_GENRE);
        assertThat(testAudiofile.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testAudiofile.getTrack()).isEqualTo(UPDATED_TRACK);
        assertThat(testAudiofile.getTotal()).isEqualTo(UPDATED_TOTAL);
        assertThat(testAudiofile.getYear()).isEqualTo(UPDATED_YEAR);
        assertThat(testAudiofile.getFieldname()).isEqualTo(UPDATED_FIELDNAME);
        assertThat(testAudiofile.getBitrate()).isEqualTo(UPDATED_BITRATE);
        assertThat(testAudiofile.getBitspersample()).isEqualTo(UPDATED_BITSPERSAMPLE);
        assertThat(testAudiofile.getCodec()).isEqualTo(UPDATED_CODEC);
        assertThat(testAudiofile.getCovermimetype()).isEqualTo(UPDATED_COVERMIMETYPE);
        assertThat(testAudiofile.getCoversize()).isEqualTo(UPDATED_COVERSIZE);
        assertThat(testAudiofile.getCovertype()).isEqualTo(UPDATED_COVERTYPE);
        assertThat(testAudiofile.getCoverheight()).isEqualTo(UPDATED_COVERHEIGHT);
        assertThat(testAudiofile.getCoverwidth()).isEqualTo(UPDATED_COVERWIDTH);
        assertThat(testAudiofile.getCovers()).isEqualTo(UPDATED_COVERS);
        assertThat(testAudiofile.getLengthseconds()).isEqualTo(UPDATED_LENGTHSECONDS);
        assertThat(testAudiofile.getMode()).isEqualTo(UPDATED_MODE);
        assertThat(testAudiofile.getSamplerate()).isEqualTo(UPDATED_SAMPLERATE);
        assertThat(testAudiofile.getTool()).isEqualTo(UPDATED_TOOL);
        assertThat(testAudiofile.getVbr()).isEqualTo(UPDATED_VBR);
        assertThat(testAudiofile.getDirectory()).isEqualTo(UPDATED_DIRECTORY);
        assertThat(testAudiofile.getExtension()).isEqualTo(UPDATED_EXTENSION);
        assertThat(testAudiofile.getFilename()).isEqualTo(UPDATED_FILENAME);
        assertThat(testAudiofile.getFilenameext()).isEqualTo(UPDATED_FILENAMEEXT);
        assertThat(testAudiofile.getFilenamerel()).isEqualTo(UPDATED_FILENAMEREL);
        assertThat(testAudiofile.getFolderpath()).isEqualTo(UPDATED_FOLDERPATH);
        assertThat(testAudiofile.getFolderpathrel()).isEqualTo(UPDATED_FOLDERPATHREL);
        assertThat(testAudiofile.getParentdirectory()).isEqualTo(UPDATED_PARENTDIRECTORY);
        assertThat(testAudiofile.getPath()).isEqualTo(UPDATED_PATH);
        assertThat(testAudiofile.getVolume()).isEqualTo(UPDATED_VOLUME);
        assertThat(testAudiofile.getWorkingdir()).isEqualTo(UPDATED_WORKINGDIR);
        assertThat(testAudiofile.getWorkingpath()).isEqualTo(UPDATED_WORKINGPATH);
        assertThat(testAudiofile.getFilecreatedate()).isEqualTo(UPDATED_FILECREATEDATE);
        assertThat(testAudiofile.getFilemoddate()).isEqualTo(UPDATED_FILEMODDATE);
        assertThat(testAudiofile.getFilesizebytes()).isEqualTo(UPDATED_FILESIZEBYTES);
        assertThat(testAudiofile.getCrcVal()).isEqualTo(UPDATED_CRC_VAL);
        assertThat(testAudiofile.getMd5Val()).isEqualTo(UPDATED_MD_5_VAL);
        assertThat(testAudiofile.getMd5audioVal()).isEqualTo(UPDATED_MD_5_AUDIO_VAL);
        assertThat(testAudiofile.getAppVal()).isEqualTo(UPDATED_APP_VAL);
    }

    @Test
    @Transactional
    void updateNonExistingAudiofile() throws Exception {
        int databaseSizeBeforeUpdate = audiofileRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAudiofileMockMvc
            .perform(put("/api/audiofiles").contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(audiofile)))
            .andExpect(status().isBadRequest());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateAudiofileWithPatch() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        int databaseSizeBeforeUpdate = audiofileRepository.findAll().size();

        // Update the audiofile using partial update
        Audiofile partialUpdatedAudiofile = new Audiofile();
        partialUpdatedAudiofile.setId(audiofile.getId());

        partialUpdatedAudiofile
            .artist(UPDATED_ARTIST)
            .album(UPDATED_ALBUM)
            .title(UPDATED_TITLE)
            .bitspersample(UPDATED_BITSPERSAMPLE)
            .covermimetype(UPDATED_COVERMIMETYPE)
            .coverwidth(UPDATED_COVERWIDTH)
            .lengthseconds(UPDATED_LENGTHSECONDS)
            .mode(UPDATED_MODE)
            .directory(UPDATED_DIRECTORY)
            .filename(UPDATED_FILENAME)
            .filenamerel(UPDATED_FILENAMEREL)
            .folderpathrel(UPDATED_FOLDERPATHREL)
            .parentdirectory(UPDATED_PARENTDIRECTORY)
            .volume(UPDATED_VOLUME)
            .workingpath(UPDATED_WORKINGPATH)
            .filecreatedate(UPDATED_FILECREATEDATE)
            .filemoddate(UPDATED_FILEMODDATE)
            .filesizebytes(UPDATED_FILESIZEBYTES)
            .md5Val(UPDATED_MD_5_VAL)
            .appVal(UPDATED_APP_VAL);

        restAudiofileMockMvc
            .perform(
                patch("/api/audiofiles")
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedAudiofile))
            )
            .andExpect(status().isOk());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeUpdate);
        Audiofile testAudiofile = audiofileList.get(audiofileList.size() - 1);
        assertThat(testAudiofile.getArtist()).isEqualTo(UPDATED_ARTIST);
        assertThat(testAudiofile.getAlbum()).isEqualTo(UPDATED_ALBUM);
        assertThat(testAudiofile.getComment()).isEqualTo(DEFAULT_COMMENT);
        assertThat(testAudiofile.getGenre()).isEqualTo(DEFAULT_GENRE);
        assertThat(testAudiofile.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testAudiofile.getTrack()).isEqualTo(DEFAULT_TRACK);
        assertThat(testAudiofile.getTotal()).isEqualTo(DEFAULT_TOTAL);
        assertThat(testAudiofile.getYear()).isEqualTo(DEFAULT_YEAR);
        assertThat(testAudiofile.getFieldname()).isEqualTo(DEFAULT_FIELDNAME);
        assertThat(testAudiofile.getBitrate()).isEqualTo(DEFAULT_BITRATE);
        assertThat(testAudiofile.getBitspersample()).isEqualTo(UPDATED_BITSPERSAMPLE);
        assertThat(testAudiofile.getCodec()).isEqualTo(DEFAULT_CODEC);
        assertThat(testAudiofile.getCovermimetype()).isEqualTo(UPDATED_COVERMIMETYPE);
        assertThat(testAudiofile.getCoversize()).isEqualTo(DEFAULT_COVERSIZE);
        assertThat(testAudiofile.getCovertype()).isEqualTo(DEFAULT_COVERTYPE);
        assertThat(testAudiofile.getCoverheight()).isEqualTo(DEFAULT_COVERHEIGHT);
        assertThat(testAudiofile.getCoverwidth()).isEqualTo(UPDATED_COVERWIDTH);
        assertThat(testAudiofile.getCovers()).isEqualTo(DEFAULT_COVERS);
        assertThat(testAudiofile.getLengthseconds()).isEqualTo(UPDATED_LENGTHSECONDS);
        assertThat(testAudiofile.getMode()).isEqualTo(UPDATED_MODE);
        assertThat(testAudiofile.getSamplerate()).isEqualTo(DEFAULT_SAMPLERATE);
        assertThat(testAudiofile.getTool()).isEqualTo(DEFAULT_TOOL);
        assertThat(testAudiofile.getVbr()).isEqualTo(DEFAULT_VBR);
        assertThat(testAudiofile.getDirectory()).isEqualTo(UPDATED_DIRECTORY);
        assertThat(testAudiofile.getExtension()).isEqualTo(DEFAULT_EXTENSION);
        assertThat(testAudiofile.getFilename()).isEqualTo(UPDATED_FILENAME);
        assertThat(testAudiofile.getFilenameext()).isEqualTo(DEFAULT_FILENAMEEXT);
        assertThat(testAudiofile.getFilenamerel()).isEqualTo(UPDATED_FILENAMEREL);
        assertThat(testAudiofile.getFolderpath()).isEqualTo(DEFAULT_FOLDERPATH);
        assertThat(testAudiofile.getFolderpathrel()).isEqualTo(UPDATED_FOLDERPATHREL);
        assertThat(testAudiofile.getParentdirectory()).isEqualTo(UPDATED_PARENTDIRECTORY);
        assertThat(testAudiofile.getPath()).isEqualTo(DEFAULT_PATH);
        assertThat(testAudiofile.getVolume()).isEqualTo(UPDATED_VOLUME);
        assertThat(testAudiofile.getWorkingdir()).isEqualTo(DEFAULT_WORKINGDIR);
        assertThat(testAudiofile.getWorkingpath()).isEqualTo(UPDATED_WORKINGPATH);
        assertThat(testAudiofile.getFilecreatedate()).isEqualTo(UPDATED_FILECREATEDATE);
        assertThat(testAudiofile.getFilemoddate()).isEqualTo(UPDATED_FILEMODDATE);
        assertThat(testAudiofile.getFilesizebytes()).isEqualTo(UPDATED_FILESIZEBYTES);
        assertThat(testAudiofile.getCrcVal()).isEqualTo(DEFAULT_CRC_VAL);
        assertThat(testAudiofile.getMd5Val()).isEqualTo(UPDATED_MD_5_VAL);
        assertThat(testAudiofile.getMd5audioVal()).isEqualTo(DEFAULT_MD_5_AUDIO_VAL);
        assertThat(testAudiofile.getAppVal()).isEqualTo(UPDATED_APP_VAL);
    }

    @Test
    @Transactional
    void fullUpdateAudiofileWithPatch() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        int databaseSizeBeforeUpdate = audiofileRepository.findAll().size();

        // Update the audiofile using partial update
        Audiofile partialUpdatedAudiofile = new Audiofile();
        partialUpdatedAudiofile.setId(audiofile.getId());

        partialUpdatedAudiofile
            .artist(UPDATED_ARTIST)
            .album(UPDATED_ALBUM)
            .comment(UPDATED_COMMENT)
            .genre(UPDATED_GENRE)
            .title(UPDATED_TITLE)
            .track(UPDATED_TRACK)
            .total(UPDATED_TOTAL)
            .year(UPDATED_YEAR)
            .fieldname(UPDATED_FIELDNAME)
            .bitrate(UPDATED_BITRATE)
            .bitspersample(UPDATED_BITSPERSAMPLE)
            .codec(UPDATED_CODEC)
            .covermimetype(UPDATED_COVERMIMETYPE)
            .coversize(UPDATED_COVERSIZE)
            .covertype(UPDATED_COVERTYPE)
            .coverheight(UPDATED_COVERHEIGHT)
            .coverwidth(UPDATED_COVERWIDTH)
            .covers(UPDATED_COVERS)
            .lengthseconds(UPDATED_LENGTHSECONDS)
            .mode(UPDATED_MODE)
            .samplerate(UPDATED_SAMPLERATE)
            .tool(UPDATED_TOOL)
            .vbr(UPDATED_VBR)
            .directory(UPDATED_DIRECTORY)
            .extension(UPDATED_EXTENSION)
            .filename(UPDATED_FILENAME)
            .filenameext(UPDATED_FILENAMEEXT)
            .filenamerel(UPDATED_FILENAMEREL)
            .folderpath(UPDATED_FOLDERPATH)
            .folderpathrel(UPDATED_FOLDERPATHREL)
            .parentdirectory(UPDATED_PARENTDIRECTORY)
            .path(UPDATED_PATH)
            .volume(UPDATED_VOLUME)
            .workingdir(UPDATED_WORKINGDIR)
            .workingpath(UPDATED_WORKINGPATH)
            .filecreatedate(UPDATED_FILECREATEDATE)
            .filemoddate(UPDATED_FILEMODDATE)
            .filesizebytes(UPDATED_FILESIZEBYTES)
            .crcVal(UPDATED_CRC_VAL)
            .md5Val(UPDATED_MD_5_VAL)
            .md5audioVal(UPDATED_MD_5_AUDIO_VAL)
            .appVal(UPDATED_APP_VAL);

        restAudiofileMockMvc
            .perform(
                patch("/api/audiofiles")
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedAudiofile))
            )
            .andExpect(status().isOk());

        // Validate the Audiofile in the database
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeUpdate);
        Audiofile testAudiofile = audiofileList.get(audiofileList.size() - 1);
        assertThat(testAudiofile.getArtist()).isEqualTo(UPDATED_ARTIST);
        assertThat(testAudiofile.getAlbum()).isEqualTo(UPDATED_ALBUM);
        assertThat(testAudiofile.getComment()).isEqualTo(UPDATED_COMMENT);
        assertThat(testAudiofile.getGenre()).isEqualTo(UPDATED_GENRE);
        assertThat(testAudiofile.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testAudiofile.getTrack()).isEqualTo(UPDATED_TRACK);
        assertThat(testAudiofile.getTotal()).isEqualTo(UPDATED_TOTAL);
        assertThat(testAudiofile.getYear()).isEqualTo(UPDATED_YEAR);
        assertThat(testAudiofile.getFieldname()).isEqualTo(UPDATED_FIELDNAME);
        assertThat(testAudiofile.getBitrate()).isEqualTo(UPDATED_BITRATE);
        assertThat(testAudiofile.getBitspersample()).isEqualTo(UPDATED_BITSPERSAMPLE);
        assertThat(testAudiofile.getCodec()).isEqualTo(UPDATED_CODEC);
        assertThat(testAudiofile.getCovermimetype()).isEqualTo(UPDATED_COVERMIMETYPE);
        assertThat(testAudiofile.getCoversize()).isEqualTo(UPDATED_COVERSIZE);
        assertThat(testAudiofile.getCovertype()).isEqualTo(UPDATED_COVERTYPE);
        assertThat(testAudiofile.getCoverheight()).isEqualTo(UPDATED_COVERHEIGHT);
        assertThat(testAudiofile.getCoverwidth()).isEqualTo(UPDATED_COVERWIDTH);
        assertThat(testAudiofile.getCovers()).isEqualTo(UPDATED_COVERS);
        assertThat(testAudiofile.getLengthseconds()).isEqualTo(UPDATED_LENGTHSECONDS);
        assertThat(testAudiofile.getMode()).isEqualTo(UPDATED_MODE);
        assertThat(testAudiofile.getSamplerate()).isEqualTo(UPDATED_SAMPLERATE);
        assertThat(testAudiofile.getTool()).isEqualTo(UPDATED_TOOL);
        assertThat(testAudiofile.getVbr()).isEqualTo(UPDATED_VBR);
        assertThat(testAudiofile.getDirectory()).isEqualTo(UPDATED_DIRECTORY);
        assertThat(testAudiofile.getExtension()).isEqualTo(UPDATED_EXTENSION);
        assertThat(testAudiofile.getFilename()).isEqualTo(UPDATED_FILENAME);
        assertThat(testAudiofile.getFilenameext()).isEqualTo(UPDATED_FILENAMEEXT);
        assertThat(testAudiofile.getFilenamerel()).isEqualTo(UPDATED_FILENAMEREL);
        assertThat(testAudiofile.getFolderpath()).isEqualTo(UPDATED_FOLDERPATH);
        assertThat(testAudiofile.getFolderpathrel()).isEqualTo(UPDATED_FOLDERPATHREL);
        assertThat(testAudiofile.getParentdirectory()).isEqualTo(UPDATED_PARENTDIRECTORY);
        assertThat(testAudiofile.getPath()).isEqualTo(UPDATED_PATH);
        assertThat(testAudiofile.getVolume()).isEqualTo(UPDATED_VOLUME);
        assertThat(testAudiofile.getWorkingdir()).isEqualTo(UPDATED_WORKINGDIR);
        assertThat(testAudiofile.getWorkingpath()).isEqualTo(UPDATED_WORKINGPATH);
        assertThat(testAudiofile.getFilecreatedate()).isEqualTo(UPDATED_FILECREATEDATE);
        assertThat(testAudiofile.getFilemoddate()).isEqualTo(UPDATED_FILEMODDATE);
        assertThat(testAudiofile.getFilesizebytes()).isEqualTo(UPDATED_FILESIZEBYTES);
        assertThat(testAudiofile.getCrcVal()).isEqualTo(UPDATED_CRC_VAL);
        assertThat(testAudiofile.getMd5Val()).isEqualTo(UPDATED_MD_5_VAL);
        assertThat(testAudiofile.getMd5audioVal()).isEqualTo(UPDATED_MD_5_AUDIO_VAL);
        assertThat(testAudiofile.getAppVal()).isEqualTo(UPDATED_APP_VAL);
    }

    @Test
    @Transactional
    void partialUpdateAudiofileShouldThrown() throws Exception {
        // Update the audiofile without id should throw
        Audiofile partialUpdatedAudiofile = new Audiofile();

        restAudiofileMockMvc
            .perform(
                patch("/api/audiofiles")
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedAudiofile))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    @Transactional
    void deleteAudiofile() throws Exception {
        // Initialize the database
        audiofileRepository.saveAndFlush(audiofile);

        int databaseSizeBeforeDelete = audiofileRepository.findAll().size();

        // Delete the audiofile
        restAudiofileMockMvc
            .perform(delete("/api/audiofiles/{id}", audiofile.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Audiofile> audiofileList = audiofileRepository.findAll();
        assertThat(audiofileList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
