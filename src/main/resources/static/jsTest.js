const globFunc = {};

globFunc.test = function (message) {
    debugger;
    let locVar = "loc";
    let ans    = undefined;

    console.log("현재 테스트 환경은 : " + locVar);

    if(prompt('우리혁 화이팅이라고 외치시겠습니까?(예,아니오)') === '예') {
        ans = confirm('globFunc.callTest 타입을 테스트 합니다. (f12 console.log)');
        if(true === ans) {
            globFunc.callTest(ans);

        } else {
            ans = 'true';
            globFunc.callTest(ans);

        }

    } else {
        alert('예 라고 쓰십시오 좆간.');
        globFunc.test();

    }
};

/**
 * function call test
 */
globFunc.callTest = function(ans) {
    let info = {'first':ans, 'second':'두번째는없다.'};
    globFunc.jsonTest(info);

}; // end globFunc.callTest = function()

/**
 * json div Test
 * @param info  first:ans, second:'^^'
 */
globFunc.jsonTest = function(info) {
    let vTest = info.first;
    if(true === vTest) {
        console.log("this variable is varTest let type of : " + typeof vTest);

    } else {
        console.log("this variable is varTest let type of : " + typeof vTest);
    }

}; // end globFunc.jsonTest = function(info)