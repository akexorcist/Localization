package com.akexorcist.localizationapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class NestedFragmentTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun nestedFragment() {
        val appCompatButton = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton.perform(scrollTo(), click())

        val appCompatImageButton = onView(withId(R.id.btn_china))
        appCompatImageButton.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView = onView(withId(R.id.textView))
        textView.check(matches(withText("蘋果樹是落葉喬木，通常樹木可高至15米，但栽培樹木一般只高3–5米左右。樹幹呈灰褐色，樹皮有一定程度的脫落。果實一般呈紅色，但需視乎品種而定。蘋果開花期是基於各地氣候而定，但一般集中在4–5月份。蘋果是異花授粉植物，大部分品種自花不能結成果實。一般蘋果栽種後，於2–3年才開始結出果實。果實成長期之長短，一般早熟品種為65–87天，中熟品種為90–133天，晚熟品種則為137–168天。在一般情形下，栽種後蘋果可有15-50年壽命。苹果原產於欧洲和中亞及中国新疆地区。哈薩克的阿拉木圖与新疆阿力麻里有蘋果城的美譽。中国古代的林檎、柰、花红等水果被认为是中国土生苹果品种或与苹果相似的水果。苹果在中国的栽培记录可以追溯至西汉时期，汉武帝时，上林苑中曾栽培林檎和柰，当时多用于薰香衣裳等，亦有置于床头当香熏或置于衣服，最初作为香囊，较少食用。但也有看法认为，林檎和柰是现在的沙果，曾被誤認為蘋果，真正意义上的苹果是元朝时期从中亚地区传入中国，当时只有在宫廷才可享用。现代汉语所说的“苹果”一词源于梵语，为古印度佛經中所說的一种水果，最早被称为“频婆”，后被汉语借用，并有“平波”、“苹婆”等写法。明朝万历年间的農書《群芳谱·果谱》中，有“苹果”词条，称：“苹果，出北地，燕赵者尤佳。接用林檎体。树身耸直，叶青，似林檎而大，果如梨而圆滑。生青，熟则半红半白，或全红，光洁可爱玩，香闻数步。味甘松，未熟者食如棉絮，过熟又沙烂不堪食，惟八九分熟者最佳”。许多中国农学史、果树史专家认为这是汉语中最早使用“苹果”一词。")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView2 = onView(withId(R.id.textViewTitle))
        textView2.check(matches(withText("您好世界")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "您好世界")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "您好世界")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "您好世界")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton2 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton2.perform(scrollTo(), click())

        val appCompatImageButton2 = onView(withId(R.id.btn_italy))
        appCompatImageButton2.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView3 = onView(withId(R.id.textView))
        textView3.check(
            matches(
                withText(
                    "La mela è il frutto (più precisamente si tratta di un falso frutto a pomo) del melo. Il melo ha origine in Asia centrale e l'evoluzione dei meli botanici risalirebbe al Neolitico. La specie è presente in Italia nominalmente con circa 2000 varietà, ma la definizione più precisa è difficile data la sovrapposizione storica delle denominazioni, e le specie estinte o irreperibili. La mela è il frutto più destagionalizzato (lo si trova tutto l'anno) e ciò richiede la presenza di impianti che provvedono alla conservazione e ne distribuiscano la disponibilità su di un ampio arco di tempo. La maturazione naturale varia da fine agosto a metà ottobre. La disponibilità alla conservazione naturale dei frutti è drasticamente diversa nelle differenti varietà; dati gli elevati contenuti in acidi organici, di norma la conservazione va da uno a quattro mesi. Nella conservazione industriale sono importanti le condizioni fisiche in cui questa avviene. Dopo il raccolto, i frutti sono conservati a temperature da 1,0 a 3,5 °C con umidità relativa del 59–68%. Per conservazioni prolungate si ricorre a conservazioni in celle con atmosfera controllata (più ricca di CO2). La mela ha un potere antiossidante (ORAC) con un indice di valore 4275[1] poiché contiene vitamine importanti come provitamina A, vitamine B1, B2, B6, E e C, niacina e acido folico, insieme a flavonoidi e carotenoidi, dall'effetto antiossidante."
                )
            )
        )

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView4 = onView(withId(R.id.textViewTitle))
        textView4.check(matches(withText("Ciao mondo")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Ciao mondo")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Ciao mondo")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Ciao mondo")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton3 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton3.perform(scrollTo(), click())

        val appCompatImageButton3 = onView(withId(R.id.btn_japan))
        appCompatImageButton3.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView5 = onView(withId(R.id.textView))
        textView5.check(matches(withText("リンゴ は、バラ科リンゴ属の落葉高木樹。またはその果実のこと。植物学上はセイヨウリンゴと呼ぶ。 原産地はカザフスタン南部、キルギスタン、タジキスタンとされており、ここからヨーロッパやアジアルートで日本にも広まったと考えられている。現在[いつ?]日本で栽培されているものは、明治時代以降に導入されたものであり、日本において、病害抵抗性、食味、収量などの点から品種改良が加えられた。人口比で比較しても日本の青森における生産量は多く、日本ブランド名で（元々の日本リンゴ農家などから商標に関する係争があり）中国でも多量に生産されている。現在[いつ?]は7500以上の品種が栽培されており、亜寒帯、亜熱帯及び温帯で栽培可能であるが、暑さに弱いため熱帯での栽培は難しい。 リンゴの木は、落葉高木で晩春頃に白い5弁花が開花する。リンゴの果実は直径約3–15 cm、重さ約35–1000 g。色は赤や黄緑または黄色をしている。熟するとヘプタコサンを含んだ蝋状の分泌物に覆われる。 リンゴの蜜は比重が大きいため、水の中に入れると沈む。他の果実の部分は比重が小さいため水に浮かぶ。")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView6 = onView(withId(R.id.textViewTitle))
        textView6.check(matches(withText("こんにちは世界")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "こんにちは世界")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "こんにちは世界")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "こんにちは世界")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton4 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton4.perform(scrollTo(), click())

        val appCompatImageButton4 = onView(withId(R.id.btn_korea))
        appCompatImageButton4.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView7 = onView(withId(R.id.textView))
        textView7.check(matches(withText("사과나무 는 장미목 장미과 배나무아과 사과나무속에 딸린 종이다. 그 열매는 사과(沙果; 砂果)라 하며, 세계적으로 가장 널리 재배되는 과일 품종 가운데 하나이다. 사전적으로 평과(苹果)라고도 한다. 나무는 높이 5~12미터에 이르는 작은 낙엽수이며, 넓고 밀집된 잔가지가 많은 수관을 가진다. 잎은 번갈아가며 배열된 모양의 단순한 타원형으로 끝은 날카롭고 톱니모양의 모서리, 가냘프고 솜털이 나 있는 하단 부분, 5~12센티미터 길이와 3~6센티미터 너비, 2~5센티미터의 잎꼭지의 특징을 가진다. 꽃은 잎과 함께 봄에 나는데 꽃 색깔은 흰색이며 처음에는 엷은 핑크색을 띠기도 한다. 직경은 2.5~3.5센티미터이며 꽃잎은 다섯 개이다. 열매는 가을에 익는데 보통 지름이 5~9센티미터이다. 드물지만 15센티미터에 이르기도 한다. 씨앗에는 미량의 사이안화물이 함유되어 있다. 과자(사과파이), 샐러드, 주스 등의 재료로 쓰이고 날로 먹는다. 농약이 묻어있으면 날로는 먹지 않는 것이 좋다. 세계적으로 재배되고 있는 품종은 700여 종이 되지만, 대한민국에서 유실수로 재배되고 있는 품종은 10여 종이다. 사과의 품종은 수확기에 따라 조생종·중생종·만생종으로 나뉘고, 색깔에 따라 홍색사과·황색사과·녹색사과로 구분한다. 현재 널리 재배되고 있는 품종에는 스타킹·골든딜리셔스·축 등이 있고, 근래에는 조나골드·후지 등이 있다. 대한민국에서는 홍옥이 오랫동안 재배되었다.")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView8 = onView(withId(R.id.textViewTitle))
        textView8.check(matches(withText("안녕하세요세계")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "안녕하세요세계")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "안녕하세요세계")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "안녕하세요세계")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton5 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton5.perform(scrollTo(), click())

        val appCompatImageButton5 = onView(withId(R.id.btn_portugal))
        appCompatImageButton5.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView9 = onView(withId(R.id.textView))
        textView9.check(
            matches(
                withText(
                    "A maçã é o pseudofruto pomáceo da macieira,1 árvore da família Rosaceae. É um dos pseudofrutos de árvore mais cultivados, e o mais conhecido dos muitos membros do género Malus que são usados \u200B\u200Bpelos seres humanos. As maçãs crescem em pequenas árvores, de folha caducifólia que florescem na Primavera e produzem fruto no Outono. A árvore é originária da Ásia Ocidental, onde o seu ancestral selvagem, Malus sieversii, ainda é encontrado atualmente. As maçãs têm sido cultivadas há milhares de anos na Ásia e Europa, tendo sido trazidas para a América do Norte pelos colonizadores europeus. As maçãs têm estado presentes na mitologia e religiões de muitas culturas, incluindo as tradições nórdica, grega e cristã. Em 2010, o genoma da fruta foi descodificado, levando a uma nova compreensão no controle de doenças e na reprodução seletiva durante a produção da maçã. Existem mais de 7.500 plantações conhecidas de maçãs, resultando numa gama de características desejadas. A maçã sempre foi uma importante fonte alimentícia em regiões de clima frio. Provavelmente, a macieira é a árvore cultivada há mais tempo pelo homem[carece de fontes]. É a espécie de fruta, à exceção dos cítricos, que pode ser conservada durante mais tempo, conservando boa parte de seu valor nutritivo. As maçãs de inverno, colhidas no final do outono e guardadas em câmaras ou armazéns acima do ponto de congelamento, têm sido um alimento destacado durante milênios na Ásia e na Europa e, desde 1800, nos Estados Unidos."
                )
            )
        )

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView10 = onView(withId(R.id.textViewTitle))
        textView10.check(matches(withText("Olá mundo")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Olá mundo")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Olá mundo")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Olá mundo")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton6 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton6.perform(scrollTo(), click())

        val appCompatImageButton6 = onView(withId(R.id.btn_thai))
        appCompatImageButton6.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView11 = onView(withId(R.id.textView))
        textView11.check(
            matches(
                withText(
                    "แอปเปิลเป็นผลไม้ในตระกูล Rosaceae แอปเปิลเป็นผลไม้ที่นิยมมากที่สุดชนิดหนึ่งในโลก เป็นไม้ผลเมืองหนาว มีต้นกำเนิดในบริเวณประเทศอิหร่านในปัจจุบัน จากนั้นจึงกระจายพันธุ์ไปยังเทือกเขาคอเคซัสและลุ่มแม่น้ำไทกริส–ยูเฟรติส แล้วแพร่หลายต่อไปในทวีปยุโรป ทวีปอเมริกา และดินแดนอื่นทั่วโลก ในประเทศไทยปลูกได้ในพื้นที่ภาคเหนือ เช่นที่ดอยอ่างขาง ต้นแอปเปิลจะสูงประมาณ 5–12 เมตร เป็นไม้เนื้อแข็ง ใบเขียวเข้มเป็นมัน ขอบหยัก ดอกออกเป็นกลุ่มสีขาวอมชมพู ผลกลมรี มีรอยบุ๋มทั้งขั้วผลและท้ายผล ผลแอปเปิลมีเปลือกบาง สีแดง เขียว และเหลืองตามสายพันธุ์ เนื้อในเป็นเหมือนทรายละเอียดสีเหลืองนวล เมล็ดมีขนาดเล็ก สีดำ แอปเปิลเป็นไม้ยืนต้นขนาดเล็ก ผลัดใบ สูง 3 – 12 เมตร เรือนยอดกว้าง กิ่งหนาแน่น ใบรูปไข่เรียงสลับ ยาว 5 – 12 ซม. กว้าง 3 – 6 ซม. ก้านใบยาว 2 - 5 ซม. ปลายใบแหลม ขอบใบหยักคล้ายฟันเลื่อย ใต้ใบปกคลุมด้วยขนนุ่มเล็กน้อย ดอกเกิดขึ้นพร้อมการแตกใบใหม่ในฤดูใบไม้ผลิ ดอกมีสีขาวแต้มสีชมพู และเข้มขึ้นเมื่อดอกใกล้โรย มีกลีบดอกห้ากลีบ เส้นผ่าศูนย์กลาง 2.5 - 3.5 ซม. ผลสุกในฤดูใบไม้ร่วง โดยทั่วไปมีเส้นผ่าศูนย์กลาง 5 - 9 ซม. กลางผลมีคาร์เพล (carpel) ห้าโพรงเรียงตัวในรูปดาวห้าแฉก แต่ละโพรงบรรจุไปด้วยเมล็ดหนึ่งถึงสามเมล็ด"
                )
            )
        )

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        pressBack()

        Thread.sleep(200)

        val textView12 = onView(withId(R.id.textViewTitle))
        textView12.check(matches(withText("สวัสดีชาวโลก")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "สวัสดีชาวโลก")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "สวัสดีชาวโลก")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "สวัสดีชาวโลก")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton7 = onView(withId(R.id.btn_activity_nested_fragment))
        appCompatButton7.perform(scrollTo(), click())

        val appCompatImageButton7 = onView(withId(R.id.btn_america))
        appCompatImageButton7.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView13 = onView(withId(R.id.textView))
        textView13.check(
            matches(
                withText(
                    "The apple tree (Malus domestica) is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple. It is cultivated worldwide as a fruit tree, and is the most widely grown species in the genus Malus. The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today. Apples have been grown for thousands of years in Asia and Europe, and were brought to North America by European colonists. Apples have religious and mythological significance in many cultures, including Norse, Greek and European Christian traditions. Apple trees are large if grown from seed, but small if grafted onto roots (rootstock). There are more than 7,500 known cultivars of apples, resulting in a range of desired characteristics. Different cultivars are bred for various tastes and uses, including cooking, eating raw and cider production. Apples are generally propagated by grafting, although wild apples grow readily from seed. Trees and fruit are prone to a number of fungal, bacterial and pest problems, which can be controlled by a number of organic and non-organic means. In 2010, the fruit's genome was decoded as part of research on disease control and selective breeding in apple production. About 80 million tons of apples were grown worldwide in 2013, and China produced almost half of this total.[3] The United States is the second-leading producer, with more than 6% of world production. Turkey is third, followed by Italy, India and Poland. Apples are often eaten raw, but can also be found in many prepared foods (especially desserts) and drinks. Many beneficial health effects are thought to result from eating apples; however, two types of allergies are attributed to various proteins found in the fruit."
                )
            )
        )

        pressBack()

        Thread.sleep(200)

        val textView14 = onView(withId(R.id.textViewTitle))
        textView14.check(matches(withText("Hello world")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Hello world")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Hello world")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Hello world")
    }
}
