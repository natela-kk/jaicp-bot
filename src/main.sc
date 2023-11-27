require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Let's start.
        go!: /Name
        intent: /how do you do || toState = "/fine"
        event: noMatch || toState = "./"

    state: Hello
        q!: привет
        intent!: /sys/aimylogic/ru/hello
        a: YOOOOY MAN
        go!: /Name
        
    state: Name
        a: What's your name?
        intent: /Сергей || toState = "/Sergey"
        intent: /Саша || toState = "/Sasha"
        intent: /Сеня || toState = "/Senya"
        intent: /Степа || toState = "/Stepa"
        intent: /Илья || toState = "/Ilia"
        event: noMatch || toState = "/RandomName"

    state: Bye
        intent!: /bye
        a: Bye bye

    state: NoMatch
        event!: noMatch
        a: что отвечать на "{{$request.query}}" я не шарю
        go!: /Bye

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        a: что-то не фурычит

    state: Sergey
        a: Ну ты Сережа бэстовый!🤩
        event: noMatch || toState = "/NoMatch"

    state: Sasha
        a: Всем втбшникам хорошего дня!😜
        event: noMatch || toState = "/NoMatch"

    state: RandomName
        a: Привет, {{$request.query}}! Хорошего денечка😘

    state: Senya
        audio: https://rr18---sn-axq7sn7l.googlevideo.com/videoplayback?expire=1701118638&ei=Tq5kZcHDHZ240u8Pk-GMsAg&ip=2a03%3Ad000%3A3107%3A9c3f%3A7ce8%3Acb91%3A4d32%3A70b9&id=o-AI1YzLOW-AVJ653icmIdly0gRod21jVlKN7lEDtuHwwW&itag=140&source=youtube&requiressl=yes&gcr=ru&spc=UWF9f3g0oQ8Md5wjleu2hiIAhP7VLNI&vprv=1&svpuc=1&mime=audio%2Fmp4&gir=yes&clen=2645703&dur=163.333&lmt=1685444668269359&keepalive=yes&fexp=24007246,24350018&beids=24350018&c=ANDROID&txp=2318224&sparams=expire%2Cei%2Cip%2Cid%2Citag%2Csource%2Crequiressl%2Cgcr%2Cspc%2Cvprv%2Csvpuc%2Cmime%2Cgir%2Cclen%2Cdur%2Clmt&sig=ANLwegAwRAIgRGnj1zwSRoonwlpcHevR2E9UNiyOk4yNGDty4ibSLqcCIFoR59Z1XIhEBXtP0VWqrmhA_N1t7XGp9Uwe-X23hWra&rm=sn-hxb54vo-bvwl7s,sn-n8vy67e&req_id=b90362edc438a3ee&cmsv=e&redirect_counter=2&cms_redirect=yes&ipbypass=yes&mh=mX&mip=84.52.73.196&mm=29&mn=sn-axq7sn7l&ms=rdu&mt=1701096569&mv=m&mvi=18&pl=22&lsparams=ipbypass,mh,mip,mm,mn,ms,mv,mvi,pl&lsig=AM8Gb2swRgIhAJBZeIgPicaIEvbfYG947hssIA01ChU25mu3JplP75pyAiEAkLUfnsC2Tz38Zg38BFIwxAyE1FnKinN1Ay5xNDLedHk%3D || name = "videoplayback"
        a: Shiiiish/@!##&*@

    state: Stepa
        a: Здарова, ни**ер

    state: Ilia
        a: H**l F***r! 