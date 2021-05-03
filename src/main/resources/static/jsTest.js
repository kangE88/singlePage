const globFunc = {};

globFunc.test = function (message) {
    debugger;
    let locVar = "loc";
    
    console.log("현재 테스트 환경은 : " + locVar);
    
    if(prompt('우리혁 화이팅이라고 외치시겠습니까?(예,아니오)') === '예') {
        let ans = confirm('globFunc.callTest를 실행합니다.');
        if(true === ans) {
            globFunc.callTest();

        } else {
            alert('종료');

        }

    } else {
        alert('예 라고 쓰십시오 좆간.');
        globFunc.test();

    }
};

/**
 * function call test
 */
globFunc.callTest = function() {
    let info = {'first':true, 'second':'true'};
    globFunc.jsonTest(info);

}; // end globFunc.callTest = function()

/**
 * json div Test
 * @param info  first:true, second:'true'
 */
globFunc.jsonTest = function(info) {
    let vTest = info.first;
    if(true === vTest) {
        console.log("this variable is varTest let");

    }
}; // end globFunc.jsonTest = function(info)