// Open simple dialogs on top of an editor. Relies on dialog.css.
!function(){function e(e,o){var n=e.getWrapperElement(),r=n.insertBefore(document.createElement("div"),n.firstChild);return r.className="CodeMirror-dialog",r.innerHTML="<div>"+o+"</div>",r}CodeMirror.defineExtension("openDialog",function(o,n){function r(){c||(c=!0,i.parentNode.removeChild(i))}var t,i=e(this,o),c=!1,u=this,d=i.getElementsByTagName("input")[0];return d?(CodeMirror.connect(d,"keydown",function(e){(13==e.keyCode||27==e.keyCode)&&(CodeMirror.e_stop(e),r(),u.focus(),13==e.keyCode&&n(d.value))}),d.focus(),CodeMirror.connect(d,"blur",r)):(t=i.getElementsByTagName("button")[0])&&(CodeMirror.connect(t,"click",function(){r(),u.focus()}),t.focus(),CodeMirror.connect(t,"blur",r)),r}),CodeMirror.defineExtension("openConfirm",function(o,n){function r(){c||(c=!0,t.parentNode.removeChild(t),u.focus())}var t=e(this,o),i=t.getElementsByTagName("button"),c=!1,u=this,d=1;i[0].focus();for(var f=0;f<i.length;++f){var s=i[f];!function(e){CodeMirror.connect(s,"click",function(o){CodeMirror.e_preventDefault(o),r(),e&&e(u)})}(n[f]),CodeMirror.connect(s,"blur",function(){--d,setTimeout(function(){0>=d&&r()},200)}),CodeMirror.connect(s,"focus",function(){++d})}})}();