package com.tuto.mowitnow;

import com.tuto.mowitnow.exceptions.ExceptionFile;
import com.tuto.mowitnow.exceptions.ExceptionMower;
import com.tuto.mowitnow.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@SpringBootTest
class MowitnowApplicationTests {

    public static final String TRUE_FILE_PATH = "./src/test/resources/input_1.txt";
    public static final String FALSE_FILE_PATH = "./src/test/resources/input_pathKO.txt";
    public static final String FALSE_DATA_FILE = "./src/test/resources/input_false_data.txt";

    @Test
    void contextLoads() {
    }

    @DisplayName("Test  MowitnowApplication.erreur_fichier_inexistant() OK")
    @Test
    public void erreur_fichier_inexistant() {

        Assertions.assertThrows(ExceptionFile.class, () -> MowitnowApplication.main(new String[]{FALSE_FILE_PATH}),
                "fichier inexistant");
    }

    @DisplayName("Test  MowitnowApplication.fichier_existe() OK")
    @Test
    public void fichier_existe_OK() {
        Assertions.assertDoesNotThrow(() -> MowitnowApplication.main(new String[]{TRUE_FILE_PATH}));
    }

    @DisplayName("Test  MowitnowApplication.fichier_vide() KO")
    @Test
    public void fichier_vide_KO() {
        Assertions.assertThrows(ExceptionMower.class, () -> MowitnowApplication.main(new String[]{FALSE_DATA_FILE}),
                Constants.ERREUR_DONNEES_INCORRECTES);
    }

}
