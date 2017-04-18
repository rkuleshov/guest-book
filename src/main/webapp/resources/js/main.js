
function addNewComment() {

    var newTitle = $('#newTitle').val();
    var newText = $('#newText').val();

    $.ajax({
            type: "POST",
            data: {userId: null, title: newTitle, text: newText},
            url: "/addComment",
            dataType: "json",
            success: function (data) {
                var commentsContainer = $('#comments');
                var title = data.title;
                var text = data.text;
                commentsContainer.append("<td>" + title + "</td>" +
                    "<td>" + text + "</td>");
            }
        }
    )
}

function newComment() {
    $("#newComment").click(function () {
        addNewComment();
    });
}

