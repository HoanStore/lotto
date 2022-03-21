console.log("main.js 가져옴");


function getLottoNum(N) {
    console.log("N : "+N);
    let list;

    $.ajax({
        type : "post",
        url: "/getNumbers",
        data: {num: N},
        dataType : "json",
        async : true,
        success : function(result)
        {
            list = result.list;
        },
        error : function(xhr, ajaxSettings, thrownError)
        {
            alert("오류가 발생하였습니다.");
        },
        complete : function()
        {
            spreadLottoNum(list);
            console.log("complete");
        }
    });
}

function spreadLottoNum(list) {
    let html = "";
    let spreadNumberHere = $("#spreadNumberHere");
    spreadNumberHere.empty();

    list.forEach(function (item, index) {
       html += `<li>`+item+`</li>`;
    });

    spreadNumberHere.append(html);
}