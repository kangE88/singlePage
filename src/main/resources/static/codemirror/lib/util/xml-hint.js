!function(){CodeMirror.xmlHints=[],CodeMirror.xmlHint=function(n,r){if(r.length>0){var t=n.getCursor();n.replaceSelection(r),t={line:t.line,ch:t.ch+1},n.setCursor(t)}var i=editor.getTokenAt;editor.getTokenAt=function(){return"disabled"},CodeMirror.simpleHint(n,e),editor.getTokenAt=i};var e=function(e){var r=e.getCursor();if(r.ch>0){for(var t=e.getRange({line:0,ch:0},r),i="",l="",o=t.length-1;o>=0;o--){if(" "==t[o]||"<"==t[o]){l=t[o];break}i=t[o]+i}t=t.slice(0,t.length-i.length);var f=n(e,t)+l,s=CodeMirror.xmlHints[f];if("undefined"==typeof s)s=[""];else{s=s.slice(0);for(var o=s.length-1;o>=0;o--)0!=s[o].indexOf(i)&&s.splice(o,1)}return{list:s,from:{line:r.line,ch:r.ch-i.length},to:r}}},n=function(e,n){var t="";if(n.length>=0){for(var i,l=new RegExp("<([^!?][^\\s/>]*).*?>","g"),o=[];null!=(i=l.exec(n));)o.push({tag:i[1],selfclose:"/>"===i[0].slice(i[0].length-2)});for(var f=o.length-1,s=0;f>=0;f--){var c=o[f];"/"==c.tag[0]?s++:0==c.selfclose&&(s>0?s--:t="<"+c.tag+">"+t)}t+=r(n)}return t},r=function(e){var n=e.lastIndexOf("<"),r=e.lastIndexOf(">");if(n>r&&(e=e.slice(n),"<"!=e)){var t=e.indexOf(" ");return 0>t&&(t=e.indexOf("	")),0>t&&(t=e.indexOf("\n")),0>t&&(t=e.length),e.slice(0,t)}return""}}();