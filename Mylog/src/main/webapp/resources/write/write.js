$(document).ready(function() {
    $('#inputTitle').on('input', function() {
        $('#outputTitle').text($(this).val());
    });
});

$(document).ready(function() {
    $('#inputText').on('input', function() {
        $('#outputText').text($(this).val());
    });
});