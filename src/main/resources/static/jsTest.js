const globFunc = {};

globFunc.test = function (message) {
    debugger;
    let locVar = "loc";

    confirm('우리혁 화이팅이라고 외치시겠습니까?', function (ans) {
        if (true == ans) {
            globFunc.callTest();
        } else {
            globFunc.test();
        }

    });
}

globFunc.callTest = function() {
    let info = {'first':true, 'second':'true'};
    globFunc.funcTest(info);
}

globFunc.funcTest = function(info) {
    let vTest = info.first;
    if(true === vTest) {
        console.log("this variable is varTest let");
    }


}