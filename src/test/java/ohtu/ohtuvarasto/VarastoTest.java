package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    //Omat lisäykset
    @Test
    public void laitetaanLiikaaTavaraa() {
        varasto.lisaaVarastoon(11);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otetaanLiikaaTavaraa() {
        varasto.lisaaVarastoon(2);
        varasto.otaVarastosta(10);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisataanAlleNollan() {
        varasto.lisaaVarastoon(-2);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void otetaanAlleNollan() {
        varasto.otaVarastosta(-2);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uusiVarastoTilavuusAlleNollan() {
        Varasto temp = new Varasto(-2);
        assertEquals(0, temp.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void toinenKonstruktoriKaikkiOk() {
        Varasto temp = new Varasto(10, 10);
        assertEquals(10, temp.getTilavuus(), vertailuTarkkuus);
        assertEquals(10, temp.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toinenKonstruktoriKaikkiNok() {
        Varasto temp = new Varasto(-10, -10);
        assertEquals(0, temp.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, temp.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toinenKonstruktoriLiikaaAlussa() {
        Varasto temp = new Varasto(10, 20);
        assertEquals(10, temp.getTilavuus(), vertailuTarkkuus);
        assertEquals(10, temp.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tulostusOk() {
        varasto.lisaaVarastoon(10);
        varasto.otaVarastosta(5);
        
        assertEquals("saldo = 5.0, vielä tilaa 5.0", varasto.toString());
        
    }
    

}
