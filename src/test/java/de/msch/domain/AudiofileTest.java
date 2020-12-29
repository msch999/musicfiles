package de.msch.domain;

import static org.assertj.core.api.Assertions.assertThat;

import de.msch.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AudiofileTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Audiofile.class);
        Audiofile audiofile1 = new Audiofile();
        audiofile1.setId(1L);
        Audiofile audiofile2 = new Audiofile();
        audiofile2.setId(audiofile1.getId());
        assertThat(audiofile1).isEqualTo(audiofile2);
        audiofile2.setId(2L);
        assertThat(audiofile1).isNotEqualTo(audiofile2);
        audiofile1.setId(null);
        assertThat(audiofile1).isNotEqualTo(audiofile2);
    }
}
