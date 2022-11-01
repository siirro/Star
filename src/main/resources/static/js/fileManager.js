let count = 0;
let flag = true;


$("#fileBtn").click(function(){
    if(count<5) {
        let add = '<div class="mb-3">';
            add = add+'<label for="file" class="form-label">File</label>';
            add = add+'<input type="file" name="files">';
            add = add+'<button type="button" class="del">X</button>';
            add = add+'</div>';

            $("#fileBtnSpace").append(add);
            count++;
    }else{
        alert("파일 5개 까지만 가능")
    }
});

$("#fileBtnSpace").on("click", ".del", function(){
    $(this).parent().remove();
    count--;
})