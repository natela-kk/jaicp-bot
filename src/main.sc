require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Let's start.
        a: yoy
        intent: /how do you do || toState = "/fine"
        event: noMatch || toState = "./"

    state: Hello
        intent!: /hello
        a: YOOOOY MAN 
        go!: /Name
    
    state: Name
        a: What's your name?

    state: Bye
        intent!: /bye
        a: Bye bye

    state: NoMatch
        event!: noMatch
        a: I do not understand. You said: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
