function equals(data, check){
    if(data == check){
        return true;
    }else{
        return false;
    }
}

function nullCheck(data, dest, kind){
    if(data == null || data==''){
        $(dest).html("FRONT : "+kind+" 빈칸일 수 없음");
        return false;
    }else{
        $(dest).html("FRONT : "+kind+" 입력 완료");
        return true;
    }
}

let results = [false, false, false];

//제목 Null Check
$("#title").keyup(function(){
    let title = $("#title").val();
    let result = nullCheck(title, "#titleErrorFront", "TITLE");
    results[0]=result;
});

$("#writer").keyup(function(){
    let writer = $("#writer").val();
    let result = nullCheck(writer, "#writerErrorFront", "WRITER");
    results[1]=result;
})

$("contents").keyup(function(){
    let contents = $("#contents").val();
    let result = nullCheck(contents, "#contentsErrorFront", "CONTENTS");
    results[2]=result;
})