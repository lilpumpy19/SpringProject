$(document).ready(function() {
    // ������� ����� ������ ��� �������� ��������
    $('#resume-form').hide();

    // ���������� ����� �� ������ "������� ������"
    $('#create-resume-button').click(function() {
        // ������� ������ "������� ������"
        $(this).hide();
        // ����������� ����� ������
        $('#resume-form').show();
    });

    // ���������� �������� ����� ������
    $('#create-resume-form').submit(function(e) {
        e.preventDefault();
        // �������������� ��� ��� ��������� �������� ����� ������
        // ...
    });
});