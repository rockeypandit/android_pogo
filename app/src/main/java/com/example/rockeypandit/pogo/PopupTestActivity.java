package com.example.rockeypandit.pogo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.podcopic.animationlib.library.AnimationType;
import com.podcopic.animationlib.library.StartSmartAnimation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class PopupTestActivity extends AppCompatActivity {
    EditText name;
    String userName;
    Button register;
    Spinner spinnerBreed;
    Spinner spinnerBreedSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_test);
        name=findViewById(R.id.name);
        register=findViewById(R.id.register);
        spinnerBreed= (Spinner) findViewById(R.id.spinnerBreeds);
        spinnerBreedSize= (Spinner) findViewById(R.id.spinnerBreedSize);


        List<String> categories = new ArrayList<String>();
        categories.add("Toy Dogs");
        categories.add("Small Dogs");
        categories.add("Medium Dogs");
        categories.add("Large Dogs");
        categories.add("Extra Large Dogs");

        ArrayAdapter<String> dataAdapterCategories = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreedSize.setAdapter(dataAdapterCategories);

        spinnerBreedSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position){
                    case 0:setSpinnerToy();
                            break;
                    case 1:setSpinnerSmall();
                        break;
                    case 2:setSpinnerMedium();
                        break;
                    case 3:setSpinnerLarge();
                        break;
                    case 4:setSpinnerXlarge();
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=name.getText().toString();
                if (userName.length()==0){
                    name.setError("Please enter user name");
                }
                else{
                    Toast.makeText(PopupTestActivity.this, "sahi h sab", Toast.LENGTH_SHORT).show();



                    StartSmartAnimation.startAnimation( findViewById(R.id.c1) , AnimationType.FadeOut , 500 , 0 , true );
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    findViewById(R.id.c2).setVisibility(View.VISIBLE);
                                }
                            },300);
                            StartSmartAnimation.startAnimation( findViewById(R.id.c2) , AnimationType.BounceIn , 500 , 0 , true );
                        }
                    },300);

                }

            }
        });









    }

    void setSpinnerToy(){

        List<String> ToyDogs = new ArrayList<String>();
        String getToyDogs = "npinscher\" width=\"35\" height=\"35\" border=\"0\" /> Affenpinscher</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/alaskanKleeKai.html\"><img src=\"../images/dogSmallThumbnails/alaskan_klee_kai.jpg\" alt=\"Alaskan Klee Kai\" width=\"35\" height=\"35\" border=\"0\" /> Alaskan Klee Kai</a></p>\n" +
                "              <p><a href=\"../breeds/americanEskimoDog.html\"><img src=\"../images/dogSmallThumbnails/american_eskimo_dog.jpg\" alt=\"American Eskimo Dog\" width=\"35\" height=\"35\" border=\"0\" /> American Eskimo Dog</a></p>\n" +
                "              <p><a href=\"../breeds/australianTerrier.html\"><img src=\"../images/dogSmallThumbnails/australian_terrier.jpg\" alt=\"Australian Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Australian Terrier</a></p>\n" +
                "              <p><a href=\"../breeds/bichonFrise.html\"><img src=\"../images/dogSmallThumbnails/bichon_frise.jpg\" alt=\"Bichon Frise\" width=\"35\" height=\"35\" border=\"0\" /> Bichon Frise</a></p>\n" +
                "              <p><a href=\"../breeds/bolognese.html\"><img src=\"../images/dogSmallThumbnails/bolognese.jpg\" alt=\"Bolognese\" width=\"35\" height=\"35\" border=\"0\" /> Bolognese</a></p>\n" +
                "              <p><a href=\"../breeds/borderTerrier.html\"><img src=\"../images/dogSmallThumbnails/border_terrier.jpg\" alt=\"Border Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Border Terrier</a></p>\n" +
                "              <p><a href=\"../breeds/brusselsGriffon.html\"><img src=\"../images/dogSmallThumbnails/brussels_griffon.jpg\" alt=\"Brussels Griffon\" width=\"35\" height=\"35\" border=\"0\" /> Brussels Griffon</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/chihuahua.html\"><img src=\"../images/dogSmallThumbnails/chihuahua.jpg\" alt=\"Chihuahua\" width=\"35\" height=\"35\" border=\"0\" /> Chihuahua</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/chineseCrested.html\"><img src=\"../images/dogSmallThumbnails/chinese_crested.jpg\" alt=\"Chinese Crested\" width=\"35\" height=\"35\" border=\"0\" /> Chinese Crested</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/dachshund.html\"><img src=\"../images/dogSmallThumbnails/dachshund.jpg\" alt=\"Dachshund\" width=\"35\" height=\"35\" border=\"0\" /> Dachshund</a></p>\n" +
                "              <p><a href=\"../breeds/havanese.html\"><img src=\"../images/dogSmallThumbnails/havanese.jpg\" alt=\"Havanese\" width=\"35\" height=\"35\" border=\"0\" /> Havanese</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/italianGreyhound.html\"><img src=\"../images/dogSmallThumbnails/italian_greyhound.jpg\" alt=\"Italian Greyhound\" width=\"35\" height=\"35\" border=\"0\" /> Italian Greyhound</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/japaneseChin.html\"><img src=\"../images/dogSmallThumbnails/japanese_chin.jpg\" alt=\"Japanese Chin\" width=\"35\" height=\"35\" border=\"0\" /> Japanese Chin</a> <strong>*</strong><br />\n" +
                "            </p></td>\n" +
                "            <td width=\"271\"><p><a href=\"../breeds/lancashireHeeler.html\"><img src=\"../images/dogSmallThumbnails/lancashire_heeler.jpg\" alt=\"Lacanshire Heeler\" width=\"35\" height=\"35\" border=\"0\" /> Lancashire Heeler</a></p>\n" +
                "              <p><a href=\"../breeds/maltese.html\"><img src=\"../images/dogSmallThumbnails/maltese.jpg\" alt=\"Maltese\" width=\"35\" height=\"35\" border=\"0\" /> Maltese</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/miniaturePinscher.html\"><img src=\"../images/dogSmallThumbnails/miniature_pinscher.jpg\" alt=\"Miniature Pinscher\" width=\"35\" height=\"35\" border=\"0\" /> Miniature Pinscher</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/norfolkTerrier.html\"><img src=\"../images/dogSmallThumbnails/norfolk_terrier.jpg\" alt=\"Norfolk Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Norfolk Terrier</a></p>\n" +
                "              <p><a href=\"../breeds/norwichTerrier.html\"><img src=\"../images/dogSmallThumbnails/norwich_terrier.jpg\" alt=\"Norwich Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Norwich Terrier</a></p>\n" +
                "              <p><a href=\"../breeds/papillon.html\"><img src=\"../images/dogSmallThumbnails/papillon.jpg\" alt=\"Papillon\" width=\"35\" height=\"35\" border=\"0\" /> Papillon</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/pomeranian.html\"><img src=\"../images/dogSmallThumbnails/pomeranian.jpg\" alt=\"Pomeranian\" width=\"35\" height=\"35\" border=\"0\" /> Pomeranian</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/shihTzu.html\"><img src=\"../images/dogSmallThumbnails/shih_tzu.jpg\" alt=\"Shih Tzu\" width=\"35\" height=\"35\" border=\"0\" /> Shih Tzu</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/silkyTerrier.html\"><img src=\"../images/dogSmallThumbnails/silky_terrier.jpg\" alt=\"Silky Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Silky Terrier</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/tibetanSpaniel.html\"><img src=\"../images/dogSmallThumbnails/tibetan_spaniel.jpg\" alt=\"Tibetan Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Tibetan Spaniel</a></p>\n" +
                "              <p><a href=\"../breeds/toyFoxTerrier.html\"><img src=\"../images/dogSmallThumbnails/toy_fox_terrier.jpg\" alt=\"Toy Fox Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Toy Fox Terrier</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/toyManchesterTerrier.html\"><img src=\"../images/dogSmallThumbnails/toy_manchester_terrier.jpg\" alt=\"Toy Manchester Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Toy Manchester Terrier</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/poodleToy.html\"><img src=\"../images/dogSmallThumbnails/poodle_toy.jpg\" alt=\"Toy Poodle\" width=\"35\" height=\"35\" border=\"0\" /> Toy Poodle</a> <strong>*</strong></p>\n" +
                "              <p><a href=\"../breeds/yorkshireTerrier.html\"><img src=\"../images/dogSmallThumbnails/yorkshire_terrier.jpg\" alt=\"Yorkshire Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Yorkshire Terrier</a> ";

        //List<String> teamName = new ArrayList<String>();
        Pattern p = compile("border=\"0\" />(.*?)</a>");
        Matcher m = p.matcher(getToyDogs);
        while (m.find()) {
           // Log.i("NAMES",m.group(1));
            //  ToyDogs.add(m.group());
            ToyDogs.add(m.group(1));

        }

        ArrayAdapter<String> dataAdapterToy = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ToyDogs);

        dataAdapterToy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(dataAdapterToy);
    }

    void setSpinnerSmall(){

        List<String> smallDogs = new ArrayList<String>();
        String getSmallDogs =" border=\"0\" /> American Cocker Spaniel</a>br />\n" +
                "              <img src=\"../images/dogSmallThumbnails/beagle.jpg\" alt=\"Beagle\" width=\"35\" height=\"35\" border=\"0\" /> Beagle</a><br />\n" +
                "                <a href=\"../breeds/bostonTerrier.html\"><img src=\"../images/dogSmallThumbnails/boston_terrier.jpg\" alt=\"Boston Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Boston Terrier</a><br />\n" +
                "                <a href=\"../breeds/cairnTerrier.html\"><img src=\"../images/dogSmallThumbnails/cairn_terrier.jpg\" alt=\"Cairn Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Cairn Terrier</a><br />\n" +
                "                <a href=\"../breeds/cavalierKingCharlesSpaniel.html\"><img src=\"../images/dogSmallThumbnails/cavalier_king_charles_spaniel.jpg\" alt=\"Cavalier King Charles Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Cavalier King Charles Spaniel</a><br />\n" +
                "                <a href=\"../breeds/ceskyTerrier.html\"><img src=\"../images/dogSmallThumbnails/cesky_terrier.jpg\" alt=\"Cesky Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Cesky Terrier</a><br />\n" +
                "                <a href=\"../breeds/chineseFoo.html\"><img src=\"../images/dogSmallThumbnails/chinese_foo.jpg\" alt=\"Chinese Foo\" width=\"35\" height=\"35\" border=\"0\" /> Chinese Foo</a><br />\n" +
                "                <a href=\"../breeds/cirnecoDellEtna.html\"><img src=\"../images/dogSmallThumbnails/cirneco_dell_etna.jpg\" alt=\"Cirneco dell'Etna\" width=\"35\" height=\"35\" border=\"0\" /> Cirneco dell’Etna</a><br />\n" +
                "                <a href=\"../breeds/cockerSpaniel.html\"><img src=\"../images/dogSmallThumbnails/cocker_spaniel.jpg\" alt=\"Cocker Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Cocker Spaniel</a><br />\n" +
                "                <a href=\"../breeds/cotonDeTulear.html\"><img src=\"../images/dogSmallThumbnails/coton_de_tulear.jpg\" alt=\"Coton de Tulear\" width=\"35\" height=\"35\" border=\"0\" /> Coton de Tulear</a><br />\n" +
                "                <a href=\"../breeds/dachshund.html\"><img src=\"../images/dogSmallThumbnails/dachshund.jpg\" alt=\"Dachshund\" width=\"35\" height=\"35\" border=\"0\" /> Dachshund</a><br />\n" +
                "                <a href=\"../breeds/dandieDinmontTerrier.html\"><img src=\"../images/dogSmallThumbnails/dandi_dinmont_terrier.jpg\" alt=\"Dandie Dinmont Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Dandie Dinmont Terrier</a><br />\n" +
                "                <a href=\"../breeds/frenchBulldog.html\"><img src=\"../images/dogSmallThumbnails/french_bulldog.jpg\" alt=\"French Bulldog\" width=\"35\" height=\"35\" border=\"0\" /> French Bulldog</a><br />\n" +
                "                <a href=\"../breeds/germanSpitz.html\"><img src=\"../images/dogSmallThumbnails/german_spitz.jpg\" alt=\"German Spitz\" width=\"35\" height=\"35\" border=\"0\" /> German Spitz</a><br />\n" +
                "                <a href=\"../breeds/icelandicSheepdog.html\"><img src=\"../images/dogSmallThumbnails/icelandic_sheepdog.jpg\" alt=\"Icelandic Sheepdog\" width=\"35\" height=\"35\" border=\"0\" /> Icelandic Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/lakelandTerrier.html\"><img src=\"../images/dogSmallThumbnails/lakeland_terrier.jpg\" alt=\"Lakeland Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Lakeland Terrier</a><br />\n" +
                "                <a href=\"../breeds/lhasaApso.html\"><img src=\"../images/dogSmallThumbnails/lhasa_apso.jpg\" alt=\"Lhasa Apso\" width=\"35\" height=\"35\" border=\"0\" /> Lhasa Apso</a><br />\n" +
                "                <a href=\"../breeds/lowchen.html\"><img src=\"../images/dogSmallThumbnails/lowchen.jpg\" alt=\"Lowchen\" width=\"35\" height=\"35\" border=\"0\" /> Lowchen</a><br />\n" +
                "                <a href=\"../breeds/manchesterTerrier.html\"><img src=\"../images/dogSmallThumbnails/manchester_terrier.jpg\" alt=\"Manchester Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Manchester Terrier</a><br />\n" +
                "                <a href=\"../breeds/miniatureAustralianShepherd.html\"><img src=\"../images/dogSmallThumbnails/miniature_australian_shepherd.jpg\" alt=\"Miniature Australian Shepherd\" width=\"35\" height=\"35\" border=\"0\" /> Miniature Australian Shepherd</a><br />\n" +
                "                <br />\n" +
                "            </p></td>\n" +
                "            <td width=\"271\"><p><a href=\"../breeds/poodleMiniature.html\"><img src=\"../images/dogSmallThumbnails/poodle_miniature.jpg\" alt=\"Miniature Poodle\" width=\"35\" height=\"35\" border=\"0\" /> Miniature Poodle<br />\n" +
                "            </a><a href=\"../breeds/miniatureSchnauzer.html\"><img src=\"../images/dogSmallThumbnails/miniature_schnauzer.jpg\" alt=\"Miniature Schnauzer\" width=\"35\" height=\"35\" border=\"0\" /> Miniature Schnauzer</a><br />\n" +
                "                <a href=\"../breeds/norwegianLundehund.html\"><img src=\"../images/dogSmallThumbnails/norwegian_lundehund.jpg\" alt=\"Norwegian Lundehund\" width=\"35\" height=\"35\" border=\"0\" /> Norwegian Lundehund</a><br />\n" +
                "                <a href=\"../breeds/parsonRussellTerrier.html\"><img src=\"../images/dogSmallThumbnails/parson_russell_terrier.jpg\" alt=\"Parson Russell Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Parson Russell Terrier</a><br />\n" +
                "                <a href=\"../breeds/portuguesePodengo.html\"><img src=\"../images/dogSmallThumbnails/portuguese_podengo.jpg\" alt=\"Portuguese Podengo\" width=\"35\" height=\"35\" border=\"0\" /> Portuguese Podengo</a><br />\n" +
                "                <a href=\"../breeds/pug.html\"><img src=\"../images/dogSmallThumbnails/pug.jpg\" alt=\"Pug\" width=\"35\" height=\"35\" border=\"0\" /> Pug</a><br />\n" +
                "                <a href=\"../breeds/pumi.html\"><img src=\"../images/dogSmallThumbnails/pumi.jpg\" alt=\"Pumi\" width=\"35\" height=\"35\" border=\"0\" /> Pumi</a><br />\n" +
                "                <a href=\"../breeds/ratTerrier.html\"><img src=\"../images/dogSmallThumbnails/rat_terrier.jpg\" alt=\"Rat Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Rat Terrier</a><br />\n" +
                "                <a href=\"../breeds/schipperke.html\"><img src=\"../images/dogSmallThumbnails/schipperke.jpg\" alt=\"Schipperke\" width=\"35\" height=\"35\" border=\"0\" /> Schipperke</a><br />\n" +
                "                <a href=\"../breeds/scottishTerrier.html\"><img src=\"../images/dogSmallThumbnails/scottish_terrier.jpg\" alt=\"Scottish Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Scottish Terrier</a><br />\n" +
                "                <a href=\"../breeds/sealyhamTerrier.html\"><img src=\"../images/dogSmallThumbnails/sealyham_terrier.jpg\" alt=\"Sealyham Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Sealyham Terrier</a><br />\n" +
                "                <a href=\"../breeds/shetlandSheepdog.html\"><img src=\"../images/dogSmallThumbnails/shetland_sheepdog.jpg\" alt=\"Shetland Sheepdog\" width=\"35\" height=\"35\" border=\"0\" /> Shetland Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/shibaInu.html\"><img src=\"../images/dogSmallThumbnails/shiba_inu.jpg\" alt=\"Shiba Inu\" width=\"35\" height=\"35\" border=\"0\" /> Shiba Inu</a><br />\n" +
                "                <a href=\"../breeds/skyeTerrier.html\"><img src=\"../images/dogSmallThumbnails/skye_terrier.jpg\" alt=\"Skye Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Skye Terrier</a><br />\n" +
                "                <a href=\"../breeds/smoothFoxTerrier.html\"><img src=\"../images/dogSmallThumbnails/smooth_fox_terrier.jpg\" alt=\"Smooth Fox Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Smooth Fox Terrier</a><br />\n" +
                "                <a href=\"../breeds/tibetanTerrier.html\"><img src=\"../images/dogSmallThumbnails/tibetan_terrier.jpg\" alt=\"Tibetan Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Tibetan Terrier</a><br />\n" +
                "                <a href=\"../breeds/welshTerrier.html\"><img src=\"../images/dogSmallThumbnails/welsh_terrier.jpg\" alt=\"Welsh Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Welsh Terrier</a><br />\n" +
                "                <a href=\"../breeds/westHighlandWhiteTerrier.html\"><img src=\"../images/dogSmallThumbnails/west_highland_white_terrier.jpg\" alt=\"West Highland White Terrier\" width=\"35\" height=\"35\" border=\"0\" /> West Highland White Terrier</a><br />\n" +
                "                <a href=\"../breeds/wireFoxTerrier.html\"><img src=\"../images/dogSmallThumbnails/wire_fox_terrier.jpg\" alt=\"Wire Fox Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Wire Fox Terrier</a><br />\n" +
                "                <a href=\"../breeds/xoloitzcuintli.html\"><img src=\"../images/dogSmallThumbnails/xoloitzcuintli.jpg\" alt=\"Xoloitzcuintli\" width=\"35\" height=\"35\" border=\"0\" /> Xoloitzcuintli</a></p>";
        //List<String> teamName = new ArrayList<String>();
        Pattern p = compile("border=\"0\" />(.*?)</a>");
        Matcher m = p.matcher(getSmallDogs);
        while (m.find()) {
            // Log.i("NAMES",m.group(1));
            //  ToyDogs.add(m.group());
            smallDogs.add(m.group(1));

        }

        ArrayAdapter<String> dataAdapterSmall = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, smallDogs);

        dataAdapterSmall.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(dataAdapterSmall);
    }

    void setSpinnerMedium(){

        List<String> mediumDogs = new ArrayList<String>();
        String getMediumDogs =" height=\"35\" border=\"0\" /> American Water Spaniel</a><br />\n" +
                "                <a href=\"../breeds/australianCattleDog.html\"><img src=\"../images/dogSmallThumbnails/australian_cattle_dog.jpg\" alt=\"Australian Cattle Dog\" width=\"35\" height=\"35\" border=\"0\" /> Australian Cattle Dog</a><br />\n" +
                "                <a href=\"../breeds/australianKelpie.html\"><img src=\"../images/dogSmallThumbnails/austrailian_kelpie.jpg\" alt=\"Australian Kelpie\" width=\"35\" height=\"35\" border=\"0\" /> Australian Kelpie</a><br />\n" +
                "                <a href=\"../breeds/australianShepherd.html\"><img src=\"../images/dogSmallThumbnails/australian_shepherd.jpg\" alt=\"Australian Shepherd\" width=\"35\" height=\"35\" border=\"0\" /> Australian Shepherd</a><br />\n" +
                "                <a href=\"../breeds/azawakh.html\"><img src=\"../images/dogSmallThumbnails/azawakh.jpg\" alt=\"Azawakh\" width=\"35\" height=\"35\" border=\"0\" /> Azawakh</a><br />\n" +
                "                <a href=\"../breeds/barbet.html\"><img src=\"../images/dogSmallThumbnails/barbet.jpg\" alt=\"Barbet\" width=\"35\" height=\"35\" border=\"0\" /> Barbet</a><br />\n" +
                "                <a href=\"../breeds/basenji.html\"><img src=\"../images/dogSmallThumbnails/basenji.jpg\" alt=\"Basenji\" width=\"35\" height=\"35\" border=\"0\" /> Basenji</a><br />\n" +
                "                <a href=\"../breeds/bassetHound.html\"><img src=\"../images/dogSmallThumbnails/basset_hound.jpg\" alt=\"Basset Hound\" width=\"35\" height=\"35\" border=\"0\" /> Basset Hound</a><br />\n" +
                "                <a href=\"../breeds/beardedCollie.html\"><img src=\"../images/dogSmallThumbnails/bearded_collie.jpg\" alt=\"Bearded Collie\" width=\"35\" height=\"35\" border=\"0\" /> Bearded Collie</a><br />\n" +
                "                <a href=\"../breeds/bedlingtonTerrier.html\"><img src=\"../images/dogSmallThumbnails/bedlington_terrier.jpg\" alt=\"Bedlington Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Bedlington Terrier</a><br />\n" +
                "                <a href=\"../breeds/borderCollie.html\"><img src=\"../images/dogSmallThumbnails/border_collie.jpg\" alt=\"Border Collie\" width=\"35\" height=\"35\" border=\"0\" /> Border Collie</a><br />\n" +
                "                <a href=\"../breeds/brittanySpaniel.html\"><img src=\"../images/dogSmallThumbnails/brittany_spaniel.jpg\" alt=\"Brittany Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Brittany Spaniel</a><br />\n" +
                "                <a href=\"../breeds/bulldog.html\"><img src=\"../images/dogSmallThumbnails/bulldog.jpg\" alt=\"Bulldog\" width=\"35\" height=\"35\" border=\"0\" /> Bulldog</a><br />\n" +
                "                <a href=\"../breeds/canaanDog.html\"><img src=\"../images/dogSmallThumbnails/canaan_dog.jpg\" alt=\"Canaan Dog\" width=\"35\" height=\"35\" border=\"0\" /> Canaan Dog</a><br />\n" +
                "                <a href=\"../breeds/cardiganWelshCorgi.html\"><img src=\"../images/dogSmallThumbnails/cardigan_welsh_corgi.jpg\" alt=\"Cardigan Welsh Corgi\" width=\"35\" height=\"35\" border=\"0\" /> Cardigan Welsh Corgi</a><br />\n" +
                "                <a href=\"../breeds/chineseChongqingDog.html\"><img src=\"../images/dogSmallThumbnails/chongqingdog.jpg\" alt=\"Chinese Chongqing Dog\" width=\"35\" height=\"35\" border=\"0\" /> Chinese Chongqing Dog</a><br />\n" +
                "                <a href=\"../breeds/chineseFoo.html\"><img src=\"../images/dogSmallThumbnails/chinese_foo.jpg\" alt=\"Chinese Foo\" width=\"35\" height=\"35\" border=\"0\" /> Chinese Foo</a><br />\n" +
                "                <a href=\"../breeds/dalmatian.html\"><img src=\"../images/dogSmallThumbnails/dalmatian.jpg\" alt=\"Dalmatian\" width=\"35\" height=\"35\" border=\"0\" /> Dalmatian</a><br />\n" +
                "                <a href=\"../breeds/englishCockerSpaniel.html\"><img src=\"../images/dogSmallThumbnails/english_cocker.jpg\" alt=\"English Cocker Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> English Cocker Spaniel</a><br />\n" +
                "                <a href=\"../breeds/englishSpringerSpaniel.html\"><img src=\"../images/dogSmallThumbnails/english_springer_spaniel.jpg\" alt=\"English Springer Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> English Springer Spaniel</a><br />\n" +
                "                <a href=\"../breeds/entlebucherMountainDog.html\"><img src=\"../images/dogSmallThumbnails/entlebucher_mountain_dog.jpg\" alt=\"Entlebucher Mountain Dog\" width=\"35\" height=\"35\" border=\"0\" /> Entlebucher Mountain Dog</a><br />\n" +
                "                <a href=\"../breeds/fieldSpaniel.html\"><img src=\"../images/dogSmallThumbnails/field_spaniel.jpg\" alt=\"Field Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Field Spaniel</a><br />\n" +
                "                <a href=\"../breeds/finnishLapphund.html\"><img src=\"../images/dogSmallThumbnails/finnish_lapphund.jpg\" alt=\"Finnish Lapphund\" width=\"35\" height=\"35\" border=\"0\" /> Finnish Lapphund</a><br />\n" +
                "                <a href=\"../breeds/finnishSpitz.html\"><img src=\"../images/dogSmallThumbnails/finnish_spitz.jpg\" alt=\"Finnish Spitz\" width=\"35\" height=\"35\" border=\"0\" /> Finnish Spitz</a><br />\n" +
                "                <a href=\"../breeds/germanPinscher.html\"><img src=\"../images/dogSmallThumbnails/german_pinscher.jpg\" alt=\"German Pinscher\" width=\"35\" height=\"35\" border=\"0\" /> German Pinscher</a><br />\n" +
                "                <a href=\"../breeds/germanSpitz.html\"><img src=\"../images/dogSmallThumbnails/german_spitz.jpg\" alt=\"German Spitz\" width=\"35\" height=\"35\" border=\"0\" /> German Spitz</a><br />\n" +
                "                <a href=\"../breeds/glenOfImaalTerrier.html\"><img src=\"../images/dogSmallThumbnails/glen_of_imaal_terrier.jpg\" alt=\"Glen of Imaal Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Glen of Imaal Terrier</a><br />\n" +
                "                <a href=\"../breeds/grandBassetGriffonVendeen.html\"><img src=\"../images/dogSmallThumbnails/gnd_basset_griffon_vendeen.jpg\" alt=\"Grand Basset Griffon Vendeen\" width=\"35\" height=\"35\" border=\"0\" /> Grand Basset Griffon Vendeen</a><br />\n" +
                "                <a href=\"../breeds/harrier.html\"><img src=\"../images/dogSmallThumbnails/harrier.jpg\" alt=\"Harrier\" width=\"35\" height=\"35\" border=\"0\" /> Harrier</a><br />\n" +
                "                <a href=\"../breeds/ibizanHound.html\"><img src=\"../images/dogSmallThumbnails/ibizan_hound.jpg\" alt=\"Ibizan Hound\" width=\"35\" height=\"35\" border=\"0\" /> Ibizan Hound</a><br />\n" +
                "                <a href=\"../breeds/jindo.html\"><img src=\"../images/dogSmallThumbnails/jindo.jpg\" alt=\"Jindo\" width=\"35\" height=\"35\" border=\"0\" /> Jindo</a><br />\n" +
                "                <a href=\"../breeds/kaiKen.html\"><img src=\"../images/dogSmallThumbnails/kai_ken.jpg\" alt=\"Kai Ken\" width=\"35\" height=\"35\" border=\"0\" /> Kai Ken</a><br />\n" +
                "                <a href=\"../breeds/keeshond.html\"><img src=\"../images/dogSmallThumbnails/keeshond.jpg\" alt=\"Keeshond\" width=\"35\" height=\"35\" border=\"0\" /> Keeshond</a><br />\n" +
                "            </p></td>\n" +
                "            <td width=\"294\"><p><a href=\"../breeds/kerryBlueTerrier.html\"><img src=\"../images/dogSmallThumbnails/kerry_blue_terrier.jpg\" alt=\"Kerry Blue Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Kerry Blue Terrier</a><br />\n" +
                "                <a href=\"../breeds/kishuKen.html\"><img src=\"../images/dogSmallThumbnails/kishu_ken.jpg\" alt=\"Kishu Ken\" width=\"35\" height=\"35\" border=\"0\" /> Kishu Ken</a><br />\n" +
                "                <a href=\"../breeds/kooikerhondje.html\"><img src=\"../images/dogSmallThumbnails/kooikerhondje.jpg\" alt=\"Kooikerhondje\" width=\"35\" height=\"35\" border=\"0\" /> Kooikerhondje</a><br />\n" +
                "                <a href=\"../breeds/lagottoRomagnolo.html\"><img src=\"../images/dogSmallThumbnails/lagotto_romagnolo.jpg\" alt=\"Lagotto Romagnolo\" width=\"35\" height=\"35\" border=\"0\" /> Lagotto Romagnolo</a><br />\n" +
                "                <a href=\"../breeds/miniatureBullTerrier.html\"><img src=\"../images/dogSmallThumbnails/miniature_bull_terrier.jpg\" alt=\"Miniature Bull Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Miniature Bull Terrier</a><br />\n" +
                "                <a href=\"../breeds/mudi.html\"><img src=\"../images/dogSmallThumbnails/mudi.jpg\" alt=\"Mudi\" width=\"35\" height=\"35\" border=\"0\" /> Mudi</a><br />\n" +
                "                <a href=\"../breeds/norrbottenspets.html\"><img src=\"../images/dogSmallThumbnails/norrbottenspets.jpg\" alt=\"Norrbottenspets\" width=\"35\" height=\"35\" border=\"0\" /> Norrbottenspets</a><br />\n" +
                "                <a href=\"../breeds/norwegianBuhund.html\"><img src=\"../images/dogSmallThumbnails/norwegian_buhund.jpg\" alt=\"Norwegian Buhund\" width=\"35\" height=\"35\" border=\"0\" /> Norwegian Buhund</a><br />\n" +
                "                <a href=\"../breeds/norwegianElkhound.html\"><img src=\"../images/dogSmallThumbnails/norwegian_elkhound.jpg\" alt=\"Norwegian Elkhound\" width=\"35\" height=\"35\" border=\"0\" /> Norwegian Elkhound</a><br />\n" +
                "                <a href=\"../breeds/novaScotiaDuckTollingRetriever.html\"><img src=\"../images/dogSmallThumbnails/ns_duck_tolling_retriever.jpg\" alt=\"Nova Scotia Duck Tolling Retriever\" width=\"35\" height=\"35\" border=\"0\" /> Nova Scotia Duck Tolling Retriever</a><br />\n" +
                "                <a href=\"../breeds/pembrokeWelshCorgi.html\"><img src=\"../images/dogSmallThumbnails/pembroke_welsh_corgi.jpg\" alt=\"Pembroke Welsh Corgi\" width=\"35\" height=\"35\" border=\"0\" /> Pembroke Welsh Corgi</a><br />\n" +
                "                <a href=\"../breeds/peruvianIncaOrchid.html\"><img src=\"../images/dogSmallThumbnails/peruvian_inca_orchid.jpg\" alt=\"Peruvian Inca Orchid\" width=\"35\" height=\"35\" border=\"0\" /> Peruvian Inca Orchid</a><br />\n" +
                "                <a href=\"../breeds/petitBassetGriffonVendeen.html\"><img src=\"../images/dogSmallThumbnails/petitbasset_griffon_vendeen.jpg\" alt=\"Petit Basset Griffon Vendeen\" width=\"35\" height=\"35\" border=\"0\" /> Petit Basset Griffon Vendeen</a><br />\n" +
                "                <a href=\"../breeds/polishLowlandSheepdog.html\"><img src=\"../images/dogSmallThumbnails/polish_lowland_sheepdog.jpg\" alt=\"Polish Lowland Sheepdog\" width=\"35\" height=\"35\" border=\"0\" /> Polish Lowland Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/portuguesePodengo.html\"><img src=\"../images/dogSmallThumbnails/portuguese_podengo.jpg\" alt=\"Portuguese Podengo\" width=\"35\" height=\"35\" border=\"0\" /> Portuguese Podengo</a><br />\n" +
                "                <a href=\"../breeds/portuguesePointer.html\"><img src=\"../images/dogSmallThumbnails/portuguese_pointer.jpg\" alt=\"Portuguese Pointer\" width=\"35\" height=\"35\" border=\"0\" /> Portuguese Pointer</a><br />\n" +
                "                <a href=\"../breeds/portugueseWaterDog.html\"><img src=\"../images/dogSmallThumbnails/portuguese_water_dog.jpg\" alt=\"Portuguese Water Dog\" width=\"35\" height=\"35\" border=\"0\" /> Portuguese Water Dog</a><br />\n" +
                "                <a href=\"../breeds/puli.html\"><img src=\"../images/dogSmallThumbnails/puli.jpg\" alt=\"Puli\" width=\"35\" height=\"35\" border=\"0\" /> Puli</a><br />\n" +
                "                <a href=\"../breeds/samoyed.html\"><img src=\"../images/dogSmallThumbnails/samoyed.jpg\" alt=\"Samoyed\" width=\"35\" height=\"35\" border=\"0\" /> Samoyed</a><br />\n" +
                "                <a href=\"../breeds/schapendoes.html\"><img src=\"../images/dogSmallThumbnails/schapendoes.jpg\" alt=\"Schapendoes\" width=\"35\" height=\"35\" border=\"0\" /> Schapendoes</a><br />\n" +
                "                <a href=\"../breeds/smallMunsterlanderPointer.html\"><img src=\"../images/dogSmallThumbnails/small_munsterlander_pointer.jpg\" alt=\"Small Munsterlander Pointer\" width=\"35\" height=\"35\" border=\"0\" /> Small Munsterlander Pointer</a><br />\n" +
                "                <a href=\"../breeds/softCoatedWheatenTerrier.html\"><img src=\"../images/dogSmallThumbnails/soft_coated_wheaten_terrier.jpg\" alt=\"Soft Coated Wheaten Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Soft Coated Wheaten Terrier</a><br />\n" +
                "                <a href=\"../breeds/spanishWaterDog.html\"><img src=\"../images/dogSmallThumbnails/spanish_water_dog.jpg\" alt=\"Spanish Water Dog\" width=\"35\" height=\"35\" border=\"0\" /> Spanish Water Dog</a><br />\n" +
                "                <a href=\"../breeds/stabyhoun.html\"><img src=\"../images/dogSmallThumbnails/stabyhoun.jpg\" alt=\"Stabyhoun\" width=\"35\" height=\"35\" border=\"0\" /> Stabyhoun</a><br />\n" +
                "                <a href=\"../breeds/staffordshireBullTerrier.html\"><img src=\"../images/dogSmallThumbnails/staffordshire_bull_terrier.jpg\" alt=\"Staffordshire Bull Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Staffordshire Bull Terrier</a><br />\n" +
                "                <a href=\"../breeds/standardSchnauzer.html\"><img src=\"../images/dogSmallThumbnails/standard_schnauzer.jpg\" alt=\"Standard Schnauzer\" width=\"35\" height=\"33\" border=\"0\" /> Standard Schnauzer</a><br />\n" +
                "                <a href=\"../breeds/sussexSpaniel.html\"><img src=\"../images/dogSmallThumbnails/sussex_spaniel.jpg\" alt=\"Sussex Spaniel\" width=\"35\" height=\"30\" border=\"0\" /> Sussex Spaniel</a><br />\n" +
                "                <a href=\"../breeds/swedishLapphund.html\"><img src=\"../images/dogSmallThumbnails/swedish_lapphund.jpg\" alt=\"Swedish Lapphund\" width=\"35\" height=\"35\" border=\"0\" /> Swedish Lapphund</a><br />\n" +
                "                <a href=\"../breeds/swedishVallhund.html\"><img src=\"../images/dogSmallThumbnails/swedish_vallhund.jpg\" alt=\"Swedish Vallhund\" width=\"35\" height=\"35\" border=\"0\" /> Swedish Vallhund</a><br />\n" +
                "                <a href=\"../breeds/treeingTennesseeBrindle.html\"><img src=\"../images/dogSmallThumbnails/treeing_tennessee_brindle.jpg\" alt=\"Treeing Tennessee Brindle\" width=\"35\" height=\"35\" border=\"0\" /> Treeing Tennessee Brindle</a><br />\n" +
                "                <a href=\"../breeds/welshSpringerSpaniel.html\"><img src=\"../images/dogSmallThumbnails/welsh_springer_spaniel.jpg\" alt=\"Welsh Springer Spaniel\" width=\"35\" height=\"36\" border=\"0\" /> Welsh Springer Spaniel</a><br />5\"\n" +
                "                <a href=\"../breeds/whippet.html\"><img src=\"../images/dogSmallThumbnails/whippet.jpg\" alt=\"Whippet\" width=\"35\" height=\"35\" border=\"0\" /> Whippet</a><b border=\"0\" /> Xoloitzcuintli</a>";
        Pattern p = compile("border=\"0\" />(.*?)</a>");
        Matcher m = p.matcher(getMediumDogs);
        while (m.find()) {
            // Log.i("NAMES",m.group(1));
            //  ToyDogs.add(m.group());
            mediumDogs.add(m.group(1));

        }

        ArrayAdapter<String> dataAdapterMedium = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mediumDogs);

        dataAdapterMedium.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(dataAdapterMedium);
    }

    void setSpinnerLarge(){

        List<String> largeDogs = new ArrayList<String>();
        String getLargeDogs ="35\" height=\"35\" border=\"0\" /> Afghan Hound</a><br />\n" +
                "                <a href=\"../breeds/airedaleTerrier.html\"><img src=\"../images/dogSmallThumbnails/airedale_terrier.jpg\" alt=\"Airedale Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Airedale Terrier</a><br />\n" +
                "                <a href=\"../breeds/akita.html\"><img src=\"../images/dogSmallThumbnails/akita.jpg\" alt=\"Akita\" width=\"35\" height=\"35\" border=\"0\" /> Akita</a><br />\n" +
                "                <a href=\"../breeds/alapahaBlueBloodBulldog.html\"><img src=\"../images/dogSmallThumbnails/alapaha_bulldog.jpg\" alt=\"Alapaha Blue Blood Bulldog\" width=\"35\" height=\"35\" border=\"0\" /> Alapaha Blue Blood Bulldog</a><br />\n" +
                "                <a href=\"../breeds/alaskanMalamute.html\"><img src=\"../images/dogSmallThumbnails/alaskan_malamute.jpg\" alt=\"Alaskan Malamute\" width=\"35\" height=\"35\" border=\"0\" /> Alaskan Malamute</a><br />\n" +
                "                <a href=\"../breeds/americanEnglishCoonhound.html\"><img src=\"../images/dogSmallThumbnails/american_english_coonhound.jpg\" alt=\"American English Coonhound\" width=\"35\" height=\"35\" border=\"0\" /> American English Coonhound</a><br />\n" +
                "                <a href=\"../breeds/americanFoxhound.html\"><img src=\"../images/dogSmallThumbnails/american_foxhound.jpg\" alt=\"American Foxhound\" width=\"35\" height=\"35\" border=\"0\" /> American Foxhound</a><br />\n" +
                "                <a href=\"../breeds/americanStaffordshireTerrier.html\"><img src=\"../images/dogSmallThumbnails/american_staffordshire_terrier.jpg\" alt=\"American Staffordshire Terrier\" width=\"35\" height=\"35\" border=\"0\" /> American Staffordshire Terrier</a><br />\n" +
                "                <a href=\"../breeds/appenzellerMountainDog.html\"><img src=\"../images/dogSmallThumbnails/appenzeller_sennenhunde.jpg\" alt=\"Appenzeller Sennenhunde\" width=\"35\" height=\"35\" border=\"0\" /> Appenzeller Sennenhunde</a><br />\n" +
                "                <a href=\"../breeds/argentineDogo.html\"><img src=\"../images/dogSmallThumbnails/argentine_dogo.jpg\" alt=\"Argentine Dogo\" width=\"35\" height=\"34\" border=\"0\" /> Argentine Dogo</a><br />\n" +
                "                <a href=\"../breeds/beauceron.html\"><img src=\"../images/dogSmallThumbnails/beauceron.jpg\" alt=\"Beauceron\" width=\"35\" height=\"35\" border=\"0\" /> Beauceron</a><br />\n" +
                "                <a href=\"../breeds/belgianLaekenois.html\"><img src=\"../images/dogSmallThumbnails/belgian_laekenois.jpg\" alt=\"Belgian Laekenois\" width=\"35\" height=\"35\" border=\"0\" /> Belgian Laekenois</a><br />\n" +
                "                <a href=\"../breeds/belgianMalinois.html\"><img src=\"../images/dogSmallThumbnails/belgian_malinois.jpg\" alt=\"Belgian Malinois\" width=\"35\" height=\"35\" border=\"0\" /> Belgian Malinois</a><br />\n" +
                "                <a href=\"../breeds/belgianSheepdog.html\"><img src=\"../images/dogSmallThumbnails/belgian_sheepdog.jpg\" alt=\"Belgian Sheepdog\" width=\"35\" height=\"32\" border=\"0\" /> Belgian Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/belgianTervuren.html\"><img src=\"../images/dogSmallThumbnails/belgian_tervuren.jpg\" alt=\"Belgian Tervuren\" width=\"35\" height=\"35\" border=\"0\" /> Belgian Tervuren</a><br />\n" +
                "                <a href=\"../breeds/bergamasco.html\"><img src=\"../images/dogSmallThumbnails/bergamasco.jpg\" alt=\"Bergamasco\" width=\"35\" height=\"35\" border=\"0\" /> Bergamasco</a><br />\n" +
                "                <a href=\"../breeds/bergerPicard.html\"><img src=\"../images/dogSmallThumbnails/berger_picard.jpg\" alt=\"Berger Picard\" width=\"35\" height=\"35\" border=\"0\" /> Berger Picard</a><br />\n" +
                "                <a href=\"../breeds/berneseMountainDog.html\"><img src=\"../images/dogSmallThumbnails/bernese_mountain_dog.jpg\" alt=\"Bernese Mountain Dog\" width=\"35\" height=\"34\" border=\"0\" /> Bernese Mountain Dog</a><br />\n" +
                "                <a href=\"../breeds/blackTanCoonhound.html\"><img src=\"../images/dogSmallThumbnails/black_and_tan_coonhound.jpg\" alt=\"Black &amp; Tan Coonhound\" width=\"35\" height=\"35\" border=\"0\" /> Black &amp; Tan Coonhound</a><br />\n" +
                "                <a href=\"../breeds/bloodhound.html\"><img src=\"../images/dogSmallThumbnails/bloodhound.jpg\" alt=\"Bloodhound\" width=\"35\" height=\"35\" border=\"0\" /> Bloodhound</a><br />\n" +
                "                <a href=\"../breeds/bluetickCoonhound.html\"><img src=\"../images/dogSmallThumbnails/bluetick_coonhound.jpg\" alt=\"Bluetick Coonhound\" width=\"35\" height=\"35\" border=\"0\" /> Bluetick Coonhound</a><br />\n" +
                "                <a href=\"../breeds/borzoi.html\"><img src=\"../images/dogSmallThumbnails/borzoi.jpg\" alt=\"Borzoi\" width=\"35\" height=\"35\" border=\"0\" /> Borzoi</a><br />\n" +
                "                <a href=\"../breeds/bouvierDesFlandres.html\"><img src=\"../images/dogSmallThumbnails/bouvier_des_flandres.jpg\" alt=\"Bouvier des Flandres\" width=\"35\" height=\"35\" border=\"0\" /> Bouvier des Flandres</a><br />\n" +
                "                <a href=\"../breeds/boxer.html\"><img src=\"../images/dogSmallThumbnails/boxer.jpg\" alt=\"Boxer\" width=\"35\" height=\"35\" border=\"0\" /> Boxer</a><br />\n" +
                "                <a href=\"../breeds/braccoItaliano.html\"><img src=\"../images/dogSmallThumbnails/bracco_italiano.jpg\" alt=\"Bracco Italiano\" width=\"35\" height=\"35\" border=\"0\" /> Bracco Italiano</a><br />\n" +
                "                <a href=\"../breeds/briard.html\"><img src=\"../images/dogSmallThumbnails/briard.jpg\" alt=\"Briard\" width=\"35\" height=\"35\" border=\"0\" /> Briard</a><br />\n" +
                "                <a href=\"../breeds/briquetGriffonVendeen.html\"><img src=\"../images/dogSmallThumbnails/briquet_griffon_vendeen.jpg\" alt=\"Briquet Griffon Vendeen\" width=\"35\" height=\"35\" border=\"0\" /> Briquet Griffon Vendeen</a><br />\n" +
                "                <a href=\"../breeds/bullTerrier.html\"><img src=\"../images/dogSmallThumbnails/bull_terrier.jpg\" alt=\"Bull Terrier\" width=\"35\" height=\"35\" border=\"0\" /> Bull Terrier</a><br />\n" +
                "                <a href=\"../breeds/caneCorso.html\"><img src=\"../images/dogSmallThumbnails/cane_corso.jpg\" alt=\"Cane Corso\" width=\"35\" height=\"35\" border=\"0\" /> Cane Corso</a><br />\n" +
                "                <a href=\"../breeds/catahoulaLeopardDog.html\"><img src=\"../images/dogSmallThumbnails/catahoula_leopard_dog.jpg\" alt=\"Catahoula Leopard Dog\" width=\"35\" height=\"35\" border=\"0\" /> Catahoula Leopard Dog</a><br />\n" +
                "                <a href=\"../breeds/chesapeakeBayRetriever.html\"><img src=\"../images/dogSmallThumbnails/chesapeake_bay_retriever.jpg\" alt=\"Chesapeake Bay Retriever\" width=\"35\" height=\"35\" border=\"0\" /> Chesapeake Bay Retriever</a><br />\n" +
                "                <a href=\"../breeds/chinook.html\"><img src=\"../images/dogSmallThumbnails/chinook.jpg\" alt=\"Chinook\" width=\"35\" height=\"35\" border=\"0\" /> Chinook</a><br />\n" +
                "                <a href=\"../breeds/chowChow.html\"><img src=\"../images/dogSmallThumbnails/chow_chow.jpg\" alt=\"Chow Chow\" width=\"35\" height=\"35\" border=\"0\" /> Chow Chow</a><br />\n" +
                "                <a href=\"../breeds/clumberSpaniel.html\"><img src=\"../images/dogSmallThumbnails/clumber_spaniel.jpg\" alt=\"Clumber Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Clumber Spaniel</a><br />\n" +
                "                <a href=\"../breeds/collie.html\"><img src=\"../images/dogSmallThumbnails/collie.jpg\" alt=\"Collie\" width=\"35\" height=\"35\" border=\"0\" /> Collie</a><br />\n" +
                "                <a href=\"../breeds/redboneCoonhound.html\"><img src=\"../images/dogSmallThumbnails/redbone_coonhound.jpg\" alt=\"Redbone Coonhound\" width=\"35\" height=\"35\" border=\"0\" /> Coonhound</a><br />\n" +
                "                <a href=\"../breeds/curlyCoatedRetriever.html\"><img src=\"../images/dogSmallThumbnails/curly_coated_retriever.jpg\" alt=\"Curly Coated Retreiver\" width=\"35\" height=\"35\" border=\"0\" /> Curly-Coated Retriever</a><br />\n" +
                "                <a href=\"../breeds/czechoslovakianWolfdog.html\"><img src=\"../images/dogSmallThumbnails/czechoslovakian_vicak.jpg\" alt=\"Czechoslovakian Wolfdog\" width=\"35\" height=\"35\" border=\"0\" /> Czechoslovakian Wolfdog</a><br />\n" +
                "            <a href=\"../breeds/dobermanPinscher.html\"><img src=\"../images/dogSmallThumbnails/doberman_pinscher.jpg\" alt=\"Doberman Pinscher\" width=\"35\" height=\"35\" border=\"0\" /> Doberman Pinscher</a>            </p></td>\n" +
                "            <td width=\"285\"><p><a href=\"../breeds/englishFoxhound.html\"><img src=\"../images/dogSmallThumbnails/english_foxhound.jpg\" alt=\"English Foxhound \" width=\"35\" height=\"35\" border=\"0\" /> English Foxhound</a><br />\n" +
                "                <a href=\"../breeds/englishSetter.html\"><img src=\"../images/dogSmallThumbnails/english_setter.jpg\" alt=\"English Setter\" width=\"35\" height=\"35\" border=\"0\" /> English Setter</a><br />\n" +
                "                <a href=\"../breeds/estrelaMountainDog.html\"><img src=\"../images/dogSmallThumbnails/estrela_mountain_dog.jpg\" alt=\"Estrela Mountain Dog\" width=\"35\" height=\"34\" border=\"0\" /> Estrela Mountain Dog</a><br />\n" +
                "                <a href=\"../breeds/eurasier.html\"><img src=\"../images/dogSmallThumbnails/eurasier.jpg\" alt=\"Eurasier\" width=\"35\" height=\"35\" border=\"0\" /> Eurasier</a><br />\n" +
                "                <a href=\"../breeds/filaBrasileiro.html\"><img src=\"../images/dogSmallThumbnails/fila_brasileiro.jpg\" alt=\"Fila Brasileiro\" width=\"35\" height=\"31\" border=\"0\" /> Fila Brasileiro</a><br />\n" +
                "                <a href=\"../breeds/flatCoatedRetriever.html\"><img src=\"../images/dogSmallThumbnails/flat_coated_retriever.jpg\" alt=\"Flat-Coated Retriever\" width=\"35\" height=\"35\" border=\"0\" /> Flat-Coated Retriever</a><br />\n" +
                "                <a href=\"../breeds/germanShepherd.html\"><img src=\"../images/dogSmallThumbnails/german_shepherd.jpg\" alt=\"German Shepherd\" width=\"35\" height=\"35\" border=\"0\" /> German Shepherd</a><br />\n" +
                "                <a href=\"../breeds/germanShorthairedPointer.html\"><img src=\"../images/dogSmallThumbnails/german_shorthaired_pointer.jpg\" alt=\"German Shorthaired Pointer\" width=\"35\" height=\"35\" border=\"0\" /> German Shorthaired Pointer</a><br />\n" +
                "                <a href=\"../breeds/germanWirehairedPointer.html\"><img src=\"../images/dogSmallThumbnails/german_wirehaired_pointer.jpg\" alt=\"German Wirehaired Pointer\" width=\"35\" height=\"35\" border=\"0\" /> German Wirehaired Pointer</a><br />\n" +
                "                <a href=\"../breeds/giantSchnauzer.html\"><img src=\"../images/dogSmallThumbnails/giant_schnauzer.jpg\" alt=\"Giant Schnauzer\" width=\"35\" height=\"35\" border=\"0\" /> Giant Schnauzer</a><br />\n" +
                "                <a href=\"../breeds/goldenRetriever.html\"><img src=\"../images/dogSmallThumbnails/golden_retriever.jpg\" alt=\"Golden Retriever\" width=\"35\" height=\"35\" border=\"0\" /> Golden Retriever</a><br />\n" +
                "                <a href=\"../breeds/gordonSetter.html\"><img src=\"../images/dogSmallThumbnails/gordon_setter.jpg\" alt=\"Gordon Setter\" width=\"35\" height=\"35\" border=\"0\" /> Gordon Setter</a><br />\n" +
                "                <a href=\"../breeds/greyhound.html\"><img src=\"../images/dogSmallThumbnails/greyhound.jpg\" alt=\"Greyhound\" width=\"35\" height=\"35\" border=\"0\" /> Greyhound</a><br />\n" +
                "                <a href=\"../breeds/irishSetter.html\"><img src=\"../images/dogSmallThumbnails/irish_setter.jpg\" alt=\"Irish Setter\" width=\"35\" height=\"35\" border=\"0\" /> Irish Setter</a><br />\n" +
                "                <a href=\"../breeds/irishWaterSpaniel.html\"><img src=\"../images/dogSmallThumbnails/irish_water_spaniel.jpg\" alt=\"Irish Water Spaniel\" width=\"35\" height=\"35\" border=\"0\" /> Irish Water Spaniel</a><br />\n" +
                "                <a href=\"../breeds/karelianBearDog.html\"><img src=\"../images/dogSmallThumbnails/karelian_bear_dog.jpg\" alt=\"Karelian Bear Dog\" width=\"35\" height=\"35\" border=\"0\" /> Karelian Bear Dog</a><br />\n" +
                "                <a href=\"../breeds/labradorRetriever.html\"><img src=\"../images/dogSmallThumbnails/labrador_retriever.jpg\" alt=\"Labrador Retriever\" width=\"35\" height=\"35\" border=\"0\" /> Labrador Retriever</a><br />\n" +
                "                <a href=\"../breeds/maremmaSheepdog.html\"><img src=\"../images/dogSmallThumbnails/maremma_sheepdog.jpg\" alt=\"Maremma Sheepdog\" width=\"35\" height=\"35\" border=\"0\" /> Maremma Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/oldEnglishSheepdog.html\"><img src=\"../images/dogSmallThumbnails/old_english_sheepdog.jpg\" alt=\"Old English Sheepdog\" width=\"35\" height=\"35\" border=\"0\" /> Old English Sheepdog</a><br />\n" +
                "                <a href=\"../breeds/otterhound.html\"><img src=\"../images/dogSmallThumbnails/otterhound.jpg\" alt=\"Otterhound\" width=\"35\" height=\"35\" border=\"0\" /> Otterhound</a><br />\n" +
                "                <a href=\"../breeds/pharaohHound.html\"><img src=\"../images/dogSmallThumbnails/pharaoh_hound.jpg\" alt=\"Pharaoh Hound\" width=\"35\" height=\"35\" border=\"0\" /> Pharaoh Hound</a><br />\n" +
                "                <a href=\"../breeds/plott.html\"><img src=\"../images/dogSmallThumbnails/plott.jpg\" alt=\"Plott\" width=\"35\" height=\"35\" border=\"0\" /> Plott</a><br />\n" +
                "                <a href=\"../breeds/pointer.html\"><img src=\"../images/dogSmallThumbnails/pointer.jpg\" alt=\"Pointer\" width=\"35\" height=\"35\" border=\"0\" /> Pointer</a><br />\n" +
                "                <a href=\"../breeds/portuguesePodengo.html\"><img src=\"../images/dogSmallThumbnails/portuguese_podengo.jpg\" alt=\"Portuguese Podengo\" width=\"35\" height=\"35\" border=\"0\" /> Portuguese Podengo</a><br />\n" +
                "                <a href=\"../breeds/redWhiteSetter.html\"><img src=\"../images/dogSmallThumbnails/red_white_setter.jpg\" alt=\"Red and White Setter\" width=\"35\" height=\"35\" border=\"0\" /> Red &amp; White Setter</a><br />\n" +
                "                <a href=\"../breeds/rhodesianRidgeback.html\"><img src=\"../images/dogSmallThumbnails/rhodesian_ridgeback.jpg\" alt=\"Rhodesian Ridgeback\" width=\"35\" height=\"35\" border=\"0\" /> Rhodesian Ridgeback</a><br />\n" +
                "                <a href=\"../breeds/rottweiler.html\"><img src=\"../images/dogSmallThumbnails/rottweiler.jpg\" alt=\"Rottweiler\" width=\"35\" height=\"35\" border=\"0\" /> Rottweiler</a><br />\n" +
                "                <a href=\"../breeds/saluki.html\"><img src=\"../images/dogSmallThumbnails/saluki.jpg\" alt=\"Saluki\" width=\"35\" height=\"34\" border=\"0\" /> Saluki</a><br />\n" +
                "                <a href=\"../breeds/chineseSharPei.html\"><img src=\"../images/dogSmallThumbnails/chinese_shar_pei.jpg\" alt=\"Shar-Pei\" width=\"35\" height=\"35\" border=\"0\" /> Shar-Pei</a><br />\n" +
                "                <a href=\"../breeds/siberianHusky.html\"><img src=\"../images/dogSmallThumbnails/siberian_husky.jpg\" alt=\"Siberian Husky\" width=\"35\" height=\"35\" border=\"0\" /> Siberian Husky</a><br />\n" +
                "                <a href=\"../breeds/sloughi.html\"><img src=\"../images/dogSmallThumbnails/sloughi.jpg\" alt=\"Sloughi\" width=\"35\" height=\"35\" border=\"0\" /> Sloughi</a><br />\n" +
                "                <a href=\"../breeds/spinoneItaliano.html\"><img src=\"../images/dogSmallThumbnails/spinone_italiano.jpg\" alt=\"Spinone Italiano\" width=\"35\" height=\"35\" border=\"0\" /> Spinone Italiano</a><br />\n" +
                "                <a href=\"../breeds/poodleStandard.html\"><img src=\"../images/dogSmallThumbnails/poodle.jpg\" alt=\"Standard Poodle\" width=\"35\" height=\"35\" border=\"0\" /> Standard Poodle</a><br />\n" +
                "                <a href=\"../breeds/thaiRidgeback.html\"><img src=\"../images/dogSmallThumbnails/thai_ridgeback.jpg\" alt=\"Thai Ridgeback\" width=\"35\" height=\"35\" border=\"0\" /> Thai Ridgeback</a><br />\n" +
                "                <a href=\"../breeds/treeingWalkerCoonhound.html\"><img src=\"../images/dogSmallThumbnails/treeing_walker_coonhound.jpg\" alt=\"Treeing Walker Coonhound\" width=\"35\" height=\"35\" border=\"0\" /> Treeing Walker Coonhound</a><br />\n" +
                "                <a href=\"../breeds/vizsla.html\"><img src=\"../images/dogSmallThumbnails/vizsla.jpg\" alt=\"Vizsla\" width=\"35\" height=\"35\" border=\"0\" /> Vizsla</a><br />\n" +
                "                <a href=\"../breeds/weimaraner.html\"><img src=\"../images/dogSmallThumbnails/weimaraner.jpg\" alt=\"Weimaraner\" width=\"35\" height=\"35\" border=\"0\" /> Weimaraner</a><br />\n" +
                "                <a href=\"../breeds/wirehairedPointingGriffon.html\"><img src=\"../images/dogSmallThumbnails/wirehaired_pointing_griffon.jpg\" alt=\"Wirehaired Pointing Griffon\" width=\"35\" height=\"35\" border=\"0\" /> Wirehaired Pointing Griffon</a><br />\n" +
                "                <a href=\"../breeds/wirehairedVizsla.html\"><img src=\"../images/dogSmallThumbnails/wirehaired_vizsla.jpg\" alt=\"Wirehaired Vizsla\" width=\"35\" height=\"35\" border=\"0\" /> Wirehaired Vizsla</a></";



        Pattern p = compile("border=\"0\" />(.*?)</a>");
        Matcher m = p.matcher(getLargeDogs);
        while (m.find()) {
            // Log.i("NAMES",m.group(1));
            //  ToyDogs.add(m.group());
            largeDogs.add(m.group(1));

        }

        ArrayAdapter<String> dataAdapterMedium = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, largeDogs);

        dataAdapterMedium.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(dataAdapterMedium);
    }

    void setSpinnerXlarge(){

        List<String> xLargeDogs = new ArrayList<String>();
        String getXlargeDogs ="border=\"0\" /> Akbash Dog</a></p>\n" +
                "              <p><a href=\"../breeds/anatolianShepherdDog.html\"><img src=\"../images/dogSmallThumbnails/anatolian_shepherd_dog.jpg\" alt=\"Anatolian Shepherd\" width=\"35\" height=\"35\" border=\"0\" /> Anatolian Shepherd</a></p>\n" +
                "              <p><a href=\"../breeds/berneseMountainDog.html\"><img src=\"../images/dogSmallThumbnails/bernese_mountain_dog.jpg\" alt=\"Bernese Mountain Dog\" width=\"35\" height=\"34\" border=\"0\" /> Bernese Mountain Dog</a></p>\n" +
                "              <p><a href=\"../breeds/blackRussianTerrier.html\"><img src=\"../images/dogSmallThumbnails/black_russian_terrier.jpg\" alt=\"Black Russian Terrier\" width=\"35\" height=\"33\" border=\"0\" /> Black Russian Terrier\n" +
                "              </a></p>\n" +
                "              <p><a href=\"../breeds/boerboel.html\"><img src=\"../images/dogSmallThumbnails/boerboel.jpg\" alt=\"Boerboel\" width=\"35\" height=\"35\" border=\"0\" /> Boerboel</a></p>\n" +
                "              <p><a href=\"../breeds/bullmastiff.html\"><img src=\"../images/dogSmallThumbnails/bullmastiff.jpg\" alt=\"Bullmastiff\" width=\"35\" height=\"35\" border=\"0\" /> Bullmastiff</a></p>\n" +
                "              <p><a href=\"../breeds/caucasianSheepdog.html\"><img src=\"../images/dogSmallThumbnails/caucasian_ovcharka.jpg\" alt=\"Caucasian Ovcharka\" width=\"35\" height=\"35\" border=\"0\" /> Caucasian Ovcharka</a></p>\n" +
                "              <p><a href=\"../breeds/centralAsianShepherdDog.html\"><img src=\"../images/dogSmallThumbnails/central_asian_shepherd_dog.jpg\" alt=\"Central Asian Shepherd Dog\" width=\"35\" height=\"35\" border=\"0\" /> Central Asian Shepherd Dog</a></p>\n" +
                "            <p><a href=\"../breeds/dogueDeBordeaux.html\"><img src=\"../images/dogSmallThumbnails/dogue_de_bordeaux.jpg\" alt=\"Dogue de Bordeaux\" width=\"35\" height=\"35\" border=\"0\" /> Dogue de Bordeaux</a></p>\n" +
                "            <p><a href=\"../breeds/greatDane.html\"><img src=\"../images/dogSmallThumbnails/great_dane.jpg\" alt=\"Great Dane\" width=\"35\" height=\"35\" border=\"0\" /> Great Dane</a></p>\n" +
                "            <p><a href=\"../breeds/greatPyrenees.html\"><img src=\"../images/dogSmallThumbnails/great_pyrenees.jpg\" alt=\"Great Pyrenees\" width=\"35\" height=\"35\" border=\"0\" /> Great Pyrenees</a></p>\n" +
                "            <p><a href=\"../breeds/greaterSwissMountainDog.html\"><img src=\"../images/dogSmallThumbnails/greater_swiss_mountain_dog.jpg\" alt=\"Greater Swiss Mountain Dog\" width=\"35\" height=\"35\" border=\"0\" /> Greater Swiss Mountain Dog</a></p>\n" +
                "            <p><a href=\"../breeds/irishWolfhound.html\"><img src=\"../images/dogSmallThumbnails/irish_wolfhound.jpg\" alt=\"Irish Wolfhound\" width=\"35\" height=\"35\" border=\"0\" /> Irish Wolfhound</a></p></td>\n" +
                "            <td width=\"285\"><p><a href=\"../breeds/komondor.html\"><img src=\"../images/dogSmallThumbnails/komondor.jpg\" alt=\"Komondor\" width=\"35\" height=\"35\" border=\"0\" /> Komondor</a></p>\n" +
                "<p><a href=\"../breeds/kuvasz.html\"><img src=\"../images/dogSmallThumbnails/kuvasz.jpg\" alt=\"Kuvasz\" width=\"35\" height=\"35\" border=\"0\" /> Kuvasz</a></p>\n" +
                "              <p><a href=\"../breeds/leonberger.html\"><img src=\"../images/dogSmallThumbnails/leonberger.jpg\" alt=\"Leonberger\" width=\"35\" height=\"35\" border=\"0\" /> Leonberger</a></p>\n" +
                "              <p><a href=\"../breeds/mastiff.html\"><img src=\"../images/dogSmallThumbnails/mastiff.jpg\" alt=\"Mastiff\" width=\"35\" height=\"35\" border=\"0\" /> Mastiff</a></p>\n" +
                "              <p><a href=\"../breeds/neapolitanMastiff.html\"><img src=\"../images/dogSmallThumbnails/neopolitan_mastiff.jpg\" alt=\"Neopolitan Mastiff\" width=\"35\" height=\"35\" border=\"0\" /> Neapolitan Mastiff</a></p>\n" +
                "              <p><a href=\"../breeds/newfoundland.html\"><img src=\"../images/dogSmallThumbnails/newfoundland.jpg\" alt=\"Newfoundland\" width=\"35\" height=\"35\" border=\"0\" /> Newfoundland</a></p>\n" +
                "              <p><a href=\"../breeds/perroDePresaCanario.html\"><img src=\"../images/dogSmallThumbnails/perro_de_presa_canario.jpg\" alt=\"Perro de Presa Canario\" width=\"35\" height=\"35\" border=\"0\" /> Perro de Presa Canario</a></p>\n" +
                "              <p><a href=\"../breeds/rafeiroDoAlentejo.html\"><img src=\"../images/dogSmallThumbnails/rafeiro_do_alentejo.jpg\" alt=\"Rafeiro do Alentejo\" width=\"35\" height=\"35\" border=\"0\" /> Rafeiro do Alentejo</a></p>\n" +
                "              <p><a href=\"../breeds/saintBernard.html\"><img src=\"../images/dogSmallThumbnails/saint_bernard.jpg\" alt=\"Saint Bernard\" width=\"35\" height=\"35\" border=\"0\" /> Saint Bernard</a></p>\n" +
                "              <p><a href=\"../breeds/scottishDeerhound.html\"><img src=\"../images/dogSmallThumbnails/scottish_deerhound.jpg\" alt=\"Scottish Deerhound\" width=\"35\" height=\"35\" border=\"0\" /> Scottish Deerhound</a></p>\n" +
                "            <p><a href=\"../breeds/tibetanMastiff.html\"><img src=\"../images/dogSmallThumbnails/tibetan_mastiff.jpg\" alt=\"Tibetan Mastiff\" width=\"35\" height=\"35\" border=\"0\" /> Tibetan Mastiff</a></p>\n" +
                "            <p><a href=\"../breeds/tosa.html\"><img src=\"../images/dogSmallThumbnails/tosa.jpg\" alt=\"Tosa\" width=\"35\" height=\"35\" border=\"0\" /> Tosa</a>";

        Pattern p = compile("border=\"0\" />(.*?)</a>");
        Matcher m = p.matcher(getXlargeDogs);
        while (m.find()) {
            // Log.i("NAMES",m.group(1));
            //  ToyDogs.add(m.group());
            xLargeDogs.add(m.group(1));

        }

        ArrayAdapter<String> dataAdapterMedium = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, xLargeDogs);

        dataAdapterMedium.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBreed.setAdapter(dataAdapterMedium);
    }




}
