package finki.ukim.mk.festival;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import finki.ukim.mk.festival.fragments.ArtistScheduleFragment;
import finki.ukim.mk.festival.fragments.ArtistsFragment;
import finki.ukim.mk.festival.fragments.BiletiFragment;
import finki.ukim.mk.festival.fragments.MapFragment;
import finki.ukim.mk.festival.fragments.ScheduleFragment;
import finki.ukim.mk.festival.models.Artist;
import finki.ukim.mk.festival.models.Location;
import finki.ukim.mk.festival.models.Makedox;
import finki.ukim.mk.festival.models.Ploshtart;
import finki.ukim.mk.festival.utilities.ListViewAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static List<Artist> artists;
    public static List<Ploshtart> ploshtart;
    public static List<Makedox> makedox;
    private ImageView featuredImageView;
    private ListView listView;

    private void populateList(){
        artists = new ArrayList<>();

        Artist artist = new Artist();
        artist.setName("Палиндром");
        artist.setBiography("Палиндром е скопско трио формирано во 2013та година. Невообичаениот состав на две бас гитари и тапани дозволува голем простор за експериментирање околу пост-панк/стонер и ноиз жанровите. Бендот го сочинуваат Кристијан Новковски (тапани), Ерик Омерагиќ (бас) и Филип Поповски (бас).");
        artist.setCountry("MK");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/Palindrom1.jpg");
        artist.setLocation(new Location("Vlez1", "41.189184", "22.719676"));
        Calendar cal = Calendar.getInstance();
        //cal.set(Calendar.DAY_OF_MONTH, 1);
        //cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Mosquito");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Conspiracy");
        artist.setBiography("Младиот скопски бенд CONSPIRACY како актуелен победник на ЛУЗЕР ФЕСТ овој јули ќе настапи на Mosquito Stage на Д Фестивал. Conspiracy во денешниот состав постои од 2016-та година, а станува збор за вистински вљубеници се во треш метал звукот, кои со својата музика сакаат да придонесат за враќањето на овој музички правец на нашата македонска сцена. Иако постојат само две години, Conspiracy дефинитивно не ја чуваат својата музика само за во гаража и се трудат што е можно повеќе својата работа да ја претстават пред публиката, па покрај настапот на ланскиот Лузер Фест, зад себе веќе имаат и десетина настапи на различни музички манифестации и во скопските клубови. Членови на Conspiracy се: Стефан Трајкоски (вокал, ритам гитара), Давор Капац (соло гитара), Иван Димишков (тапани) и Милош Благоевиќ (бас гитара).");
        artist.setCountry("MK");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/Conspiracy1.jpg");
        cal = Calendar.getInstance();
        //cal.set(Calendar.DAY_OF_MONTH, 1);
        //cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Mosquito");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Disciples");
        artist.setBiography("Оваа низа овој јули продолжува со потврдениот настап на светскиот музички феномен, лондонското трио DISCIPLES кое директно од светските денс топ листи ќе ги донесе своите бројни хитови на главната бина на Д ФЕСТИВАЛ. Лондонското трио Disciples „експлодира“ на светската сцена со хитот „How Deep Is Your Love“ изработен во соработка со славниот Келвин Харис. По синглот кој во моментов надминува милијарда прегледувања на „ЈуТјуб“, ги препозна и поддржа и легендарниот Пит Тонг од Би-Би-Си, по што со молскавична брзина се пробија на највисоките позиции на сите релевантни светски топ листи. Членовите на триото Дувал, Лук Мак и Гавин Кол самите ја пишуваат, пејат и продуцираат својата музика, а истакнато место на листите им оствари еден од најслушаните синглови во 2017-та, „On My Mind“!");
        artist.setCountry("UK");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/Disciples1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 7);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("FINK");
        artist.setBiography("Животот во музиката е околу малите победи – првото це-де, првата распродадена изведба, првата тура со „автобус“… ако ги поминеш сите овие предизвици, секогаш се појавуваат нови репери.“ Финк\n" +
                "\n" +
                "Resurgam – што значи, „Повторно ќе се возвишам“ – е новиот албум на Финк: музичарот родум од Велика Британија кој моментално е базиран во Берлин, Фин Гринал, заедно со останатите членови и другари од бендот, Тим Торнтон (тапани, гитара) и Гај Витекер (бас). Насловот е преземен од латинскиот натпис на фреската која е исцртана во црквата во Корнвал, родниот град на Гринал; неговиот тон го отелотворува нескротливиот дух на новиот албум. Финк досега имаат издадено четири повеќе-слојни, богати студиски албуми, „Distance And Time“ (2007), „Sort Of Revolution“ (2009), „Perfect Darkness“ (2011) и „Hard Believer“ (2014).\n" +
                "\n" +
                "„Додека ја пишував песната, мислите постојано ми се навраќаа кон малата црква веднаш до плажата во Корнвал, каде што пораснав,“ – тој вели. „Отсекогаш сум ја сакал таа околина; црквичката е стара околу 900 години и многу е романтична, на ѕидот има голема слика, со натписот: „Resurgam“. Кога патуваш често, ослободен си од ограничувањата на твојата територија. Но, исто така, некаде си ги собираш и ваквите места на кои се навраќаш.“\n" +
                "\n" +
                "Музичката страст на Гринал е длабоко вкоренета и особено разновидна; своето детство го има поминато слушајќи ја семејната музичка колекција и играјќи си со татковиот снимач на траки, пред сам да се научи да свири на гитара (подоцна, ќе го вложи студентскиот заем во сајзер и семплер). Со својот независен дух, тој станува и се докажува како инспиративен соработник во пишувањето и продуцирањето на песните на тогашната тинејџерка, Ејми Вајнхаус и подоцна работи заедно со американската соул ѕвезда, Џон Леџенд. Од друга страна пак, работата на Финк во филмската индустрија исто така ја рефлектира силата на нивното раскажување и вивидното предание.\n" +
                "\n" +
                "Кога Финк не патуваат – Гринал е стациониран во Берлин. Далечината никогаш не го раздвоила од неговите долгогодишни другари од бендот, Торнтон и Витекер: музички визионери кои се интегрален дел од креативниот процес на Финк. Уште од првата свирка на Финк, во Лондон, во 2005 година, заедно настапувале над 500 пати во живо, на најчудни и најнормални места, од бинго сала во студиото на ББС.\n" +
                "Во албумот „Resurgam“ ништо не е зацврстено, додека можностите даваат ослободувачко чувство. 10-те песни од албумот се снимени во период од два месеци, релативно луксузно долг период на време за Финк. Експресијата на Финк носи мелодија која останува со тебе, дури и откако последната нота ќе замре. На „Resurgam“ таа енергија постојано расне, туркајќи ги нешатата нанапред.");
        artist.setCountry("UK");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/Fink1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 8);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Дуке Бојаџиев");
        artist.setBiography("Дуке Бојаџиев е Македонски композитор кој од 2001 година живее и работи во ЊуЈорк. Тој има дипломирано на Медицинскиот Факултет во Скопје, а потоа на музичкиот колеџ Беркли во Бостон. Низ неговата интернационална кариера Дуке има работено со добитници на Оскар како Џонатан Деми и Данис Танович, како и со Рајко Грлич, Вељко Булајич и Столе Попов. Неговата музика е користена за светски кампањи на брендови како Пежо, Ланком и Лореал, разни светски компилации како Буда Бар и Маракеш Експрес. Има работено со артисти како Синди Лопер и Телепоп Мјузик, а има настапувано во светски дворани, меѓу кои Карнеги Хол во Њу Јорк, Авалон Театар во Лос Анџелес и Античкиот Театар во Охрид.");
        artist.setCountry("MK/USA");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/DukeB1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 8);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Горан Трајковски");
        artist.setBiography("Горан Трајкоски е македонски композитор на театарска и филмска музика, инструменталист, вокален интерпретатор, основач на рок групите Падот на Византија и Анастасија. Бил соработник на неколку дискографски изданија и настапувал со групи и музичари како Мизар, Кирил Џајковски, Елена Христова, Александар Велјанов, Deine Lakaien и Mooger Fooger. Студирал англиски јазик и книжевност , но музички сам се образувал учејќи ја традиционалната македонска музика од Пеце Атанасовски, македонското и традиционалното источно црковно пеење од oтец Стефан Санџаковски. Својата прва музика за театарска претстава ја направил во 1989 година, а до денес работел музика за повеќе од 80тина театарски претстави и филмови.");
        artist.setCountry("MK");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/Gotra1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 7);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Who See");
        artist.setBiography("Who See е црногорско хип-хоп дуо од Бока Которска. Бендот на почетокот на 2000-тите го оформија Dedduh (Дејан Дедовиќ) и Noyz (Марио Ѓорѓевиќ) објавувајќи ја првата демо песна „Dim po dim“. Во 2007-ма го објавија дебитантскиот албум „Sviranje kupcu“, но фокусот на пошироката јавност го достигнаа по објавувањето на синглот „Reggaeton Montenegro“ и албумот „Krš i drača“ во 2013-та. Препознатливи по своите вицкастите текстови во опуштена изведба и карактеристичните спотови, тие без проблем истата година ја освоија и MTV наградата за најдобар регионален изведувач. Таа година Who See ја претставуваа Црна Гора и на натпреварувањето за песна на Евровизија во Малме во Шведска.\n" +
                "\n" +
                "Нивниот најуспешен албум „Nemam ti kad“ е објавен во 2014-та година и привлече огромно внимание на публиката ширум Балканот. Водечките синглови од албумот „Nemam ti kad“ и „Dje se kupaš“ се најдоа на самиот врв на сите регионални топ листи.\n" +
                "\n" +
                "Актуелниот албум пак, „Pamidore“ во јули 2017-та го објави издавачката куќа Lampshade Media. Првиот сингл од овој албум, песната „Naselje“ стана инстант хит, додека од албумот се издвоија и песните „Pucačina po Budvi“, „Krokodil“ и „Golf 2“.\n" +
                "\n" +
                "Who See лани учествуваа и во интернационалниот проект Tuborg Open во која прилика соработуваа со реномираната светска атракција Major Lazer, а ова лето на 6-ти јули тие за прв пат ќе настапат во Македонија и тоа на главната бина на Д ФЕСТИВАЛ во Дојран.");
        artist.setCountry("ME");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/WhoSee1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 6);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Pussy Riot");
        artist.setBiography("На 8-ми јули Д Фестивал ќе биде домаќин и на основачката на Pussy Riot, руската новинарка, активистка и уметница Марија Аљохина! Добитничката на наградите The Hannah Arendt и The LennonOno Grant for Peace, ќе ни го претстави нејзиниот музички и театарски проект „Riot Days by Pussy Riot Theatre“ подготвен врз основа на нејзината последна книга Riot Days. На главната бина на Фестивалот ќе го погледнеме перформансот за активизмот, политичкиот отпор, злоупотребата на моќта, нечовечните услови во затворите, но и за надежта за подобро општество. Не треба многу да се објаснува кои се Pussy Riot, рускиот арт колектив веќе глобално важи за еден од најзначајните активистички гласови во последните 10 години, а членовите на Pussy Riot со нивното бескомпромисно и упорно залагање за човековите права и слободи, секако го заслужуваат своето место и внимание на фестивалите од калибарот на Д ФЕСТИВАЛ кои промовирајќи го фестивалскиот дух и акцентирајќи ги позитивните вредности претставуваат многу повеќе од само одлична музичка програма. Спојувајќи ги театарот, филмот и музиката, овој активистички проект на Марија Аљохина ја раскажува сторијата на дисидентската панк група затворена во Русија поради критикување на власта. „Слободата не постои доколку секојдневно не се борите за неа,“ – вели Аљохина. Нам пак, особено ни е драго дека покрај концертот, нивниот перформанс ќе го отвори и размислувањето за улогата на слободната уметност и нејзиниот однос со политиката.");
        artist.setCountry("RU");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/PussyRiot1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 8);
        cal.set(Calendar.MONTH, 8);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Main");
        artists.add(artist);

        artist = new Artist();
        artist.setName("Koala Voice");
        artist.setBiography("KOALA VOICE се четири клинци од најиндустрискиот дел во Словенија. Со нивното свежо комбинирање на инди музиката со рок и поп звукот од ’70-тите, ги освоија срцата и гласовите на словенечкиот натпревар на средношколските бендови во 2014 година. Иако тогаш сѐ уште беа средношколци, работите се развиваа многу брзо за младиот бенд и продолжуваат со истото темпо, со договори за издавање, многу концерти и фестивалски настапи како оние на EXIT, Eurosonic, Tallinn Music Week, Wild Mint во Русија, Reeperbahn, Waves Vienna, Waves Bratislava и други низ Европа, а меѓу кои и ТАКСИРАТ фестивалот во 2016-та каде што KOALA VOICE го имаа убедливо најпосетениот настап на скопската PIN Music Conference таа година.  Во моментов бендот е актуелен со својот нов, втор и самостојно објавен, албум Wolkenfabrik чиј материјал ќе ни го претстават на сцена, онаму каде што всушност се најдобри.");
        artist.setCountry("SI");
        artist.setImageUrl("http://dfestival.mk/wp-content/uploads/2018/03/KoalaVoice1.jpg");
        cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 7);
        cal.set(Calendar.MONTH, 7);
        cal.set(Calendar.YEAR, 2018);
        cal.add(Calendar.DAY_OF_MONTH, 5);
        artist.setDate(cal.getTime());
        artist.setStage("Mosquito");
        artists.add(artist);


        ploshtart = new ArrayList<>();


        makedox = new ArrayList<>();

        Makedox mak = new Makedox();
        mak.setName("Марта и Ники");
        mak.setDuration(90);
        mak.setCountry("Шведска");
        mak.setDirection("Tora Martens");
        mak.setDescription("Првото женско хип-хоп дуо што некогаш го освоило првото место на најважниот меѓународен натпревар за улично танцување.");
        mak.setImageUrl("http://dfestival.mk/wp-content/uploads/2017/07/MarthaNiki-01.jpg");
        cal = Calendar.getInstance();
        cal.set(2018, 07, 6, 15, 30);
        mak.setDate(cal.getTime());
        makedox.add(mak);

        mak = new Makedox();
        mak.setName("Мојот превртен свет");
        mak.setDuration(75);
        mak.setCountry("Словенија, Хрватска, Македонија");
        mak.setDirection("Petra Seliškar");
        mak.setDescription("Колку е тешко и чисто создавањето уметност?");
        mak.setImageUrl("http://dfestival.mk/wp-content/uploads/2017/06/MyWorldIsUpsideDown-01.jpg");
        cal = Calendar.getInstance();
        cal.set(2018, 07, 6, 17, 30);
        mak.setDate(cal.getTime());
        makedox.add(mak);

        mak = new Makedox();
        mak.setName("Во потрага по Фела");
        mak.setDuration(119);
        mak.setCountry("САД");
        mak.setDirection("Alex Gibney");
        mak.setDescription("Треба ли активизмот да има граници? Фела Кути знае најдобро.");
        mak.setImageUrl("http://dfestival.mk/wp-content/uploads/2017/06/FindingFela-01.jpg");
        cal = Calendar.getInstance();
        cal.set(2018, 07, 7, 15, 30);
        mak.setDate(cal.getTime());
        makedox.add(mak);

        mak = new Makedox();
        mak.setName("Чија е оваа песна?");
        mak.setDuration(70);
        mak.setCountry("Белгија, Бугарија");
        mak.setDirection("Adela Peeva");
        mak.setDescription("Дали една иста песна може да смени нечија судбина?");
        mak.setImageUrl("http://dfestival.mk/wp-content/uploads/2017/06/WhoseIsThisSong-01.jpg");
        cal = Calendar.getInstance();
        cal.set(2018, 07, 8, 15, 30);
        mak.setDate(cal.getTime());
        makedox.add(mak);



    }

    private void init(){
        featuredImageView = findViewById(R.id.featuredImage);

        featuredImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://dfestival.mk/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        listView = findViewById(R.id.list);
        populateList();
        ListViewAdapter adapter=new ListViewAdapter(this, artists);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.view_schedule_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        init();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Class fragmentClass = null;


        if (id == R.id.nav_najnovo) {

        } else if (id == R.id.nav_artisti) {
            fragmentClass = ArtistsFragment.class;
        } else if (id == R.id.nav_ploshtart) {

        } else if (id == R.id.nav_makedoks) {

        } else if (id == R.id.nav_raspored) {
            fragmentClass = ArtistScheduleFragment.class;
        } else if (id == R.id.nav_novosti) {

        } else if (id == R.id.nav_mapa) {
            startActivity(new Intent(MainActivity.this, MapFragment.class));
        } else if (id == R.id.nav_bileti) {
            startActivity(new Intent(MainActivity.this, BiletiFragsment.class));
        }

        if(fragmentClass!=null) {
            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = null;
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (fragment == null)
                return false;

            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
