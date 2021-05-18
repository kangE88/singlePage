// ============== Formatting extensions ============================
!function(){function e(e){for(var n=[/for\s*?\((.*?)\)/,/\"(.*?)(\"|$)/,/\'(.*?)(\'|$)/,/\/\*(.*?)(\*\/|$)/,/\/\/.*/],r=[],t=0;t<n.length;t++)for(var o=0;o<e.length;){var a=e.substr(o).match(n[t]);if(null==a)break;r.push({start:o+a.index,end:o+a.index+a[0].length}),o+=a.index+Math.max(1,a[0].length)}return r.sort(function(e,n){return e.start-n.start}),r}function n(e,n){return CodeMirror.innerMode(e.getMode(),e.getTokenAt(n).state).mode}function r(e,n,r,t){var o=e.getMode(),a=e.getLine(n);if(null==t&&(t=a.length),!o.innerMode)return[{from:r,to:t,mode:o}];var i=e.getTokenAt({line:n,ch:r}).state,s=CodeMirror.innerMode(o,i).mode,d=[],c=new CodeMirror.StringStream(a);for(c.pos=c.start=r;;){o.token(c,i);var m=CodeMirror.innerMode(o,i).mode;if(m!=s){var l=c.start;"xml"==s.name&&">"==a.charAt(c.pos-1)&&(l=c.pos),d.push({from:r,to:l,mode:s}),r=l,s=m}if(c.pos>=t)break;c.start=c.pos}return t>r&&d.push({from:r,to:t,mode:s}),d}CodeMirror.extendMode("css",{commentStart:"/*",commentEnd:"*/",wordWrapChars:[";","\\{","\\}"],autoFormatLineBreaks:function(e){return e.replace(new RegExp("(;|\\{|\\})([^\r\n])","g"),"$1\n$2")}}),CodeMirror.extendMode("javascript",{commentStart:"/*",commentEnd:"*/",wordWrapChars:[";","\\{","\\}"],autoFormatLineBreaks:function(n){var r=0,t=/(;|\{|\})([^\r\n;])/g,o=e(n);if(null!=o){for(var a="",i=0;i<o.length;i++)o[i].start>r&&(a+=n.substring(r,o[i].start).replace(t,"$1\n$2"),r=o[i].start),o[i].start<=r&&o[i].end>=r&&(a+=n.substring(r,o[i].end),r=o[i].end);return r<n.length&&(a+=n.substr(r).replace(t,"$1\n$2")),a}return n.replace(t,"$1\n$2")}}),CodeMirror.extendMode("xml",{commentStart:"<!--",commentEnd:"-->",wordWrapChars:[">"],autoFormatLineBreaks:function(e){for(var n=e.split("\n"),r=new RegExp("(^\\s*?<|^[^<]*?)(.+)(>\\s*?$|[^>]*?$)"),t=new RegExp("<","g"),o=new RegExp("(>)([^\r\n])","g"),a=0;a<n.length;a++){var i=n[a].match(r);null!=i&&i.length>3&&(n[a]=i[1]+i[2].replace(t,"\n$&").replace(o,"$1\n$2")+i[3])}return n.join("\n")}}),CodeMirror.defineExtension("commentRange",function(e,r,t){var o=n(this,r),a=this;this.operation(function(){if(e)a.replaceRange(o.commentEnd,t),a.replaceRange(o.commentStart,r),r.line==t.line&&r.ch==t.ch&&a.setCursor(r.line,r.ch+o.commentStart.length);else{var n=a.getRange(r,t),i=n.indexOf(o.commentStart),s=n.lastIndexOf(o.commentEnd);i>-1&&s>-1&&s>i&&(n=n.substr(0,i)+n.substring(i+o.commentStart.length,s)+n.substr(s+o.commentEnd.length)),a.replaceRange(n,r,t)}})}),CodeMirror.defineExtension("autoIndentRange",function(e,n){var r=this;this.operation(function(){for(var t=e.line;t<=n.line;t++)r.indentLine(t,"smart")})}),CodeMirror.defineExtension("autoFormatRange",function(e,n){var t=this;t.operation(function(){for(var o=e.line,a=n.line;a>=o;++o){for(var i={line:o,ch:o==e.line?e.ch:0},s={line:o,ch:o==a?n.ch:null},d=r(t,o,i.ch,s.ch),c="",m=t.getRange(i,s),l=0;l<d.length;++l){var u=d.length>1?m.slice(d[l].from,d[l].to):m;c&&(c+="\n"),c+=d[l].mode.autoFormatLineBreaks?d[l].mode.autoFormatLineBreaks(u):m}if(c!=m){for(var f=0,g=c.indexOf("\n");-1!=g;g=c.indexOf("\n",g+1),++f);t.replaceRange(c,i,s),o+=f,a+=f}}for(var o=e.line+1;a>=o;++o)t.indentLine(o,"smart");t.setSelection(e,t.getCursor(!1))})})}();