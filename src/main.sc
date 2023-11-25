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
        event: noMatch || toState = "/RandomName"

    state: Bye
        intent!: /bye
        a: Bye bye

    state: NoMatch
        event!: noMatch
        a: что отвечать на {{$request.query}} я не шарю
        go!: /Bye

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        a: что-то не фурычит

    state: Sergey
        a: Пахнешь слабостью...😌
        event: noMatch || toState = "/NoMatch"

    state: Sasha
        a: Всем втбшникам хорошего дня!😜
        event: noMatch || toState = "/NoMatch"

    state: RandomName
        a: Привет, {{$request.query}}! Хорошего денечка😘