
var token = localStorage.getItem('token');
$(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var vacancyId = urlParams.get('vacancyId'); // �������� ������������� �������� �� URL (��������, ����� �������� �������)
    console.log('sssssssssss');
    // ��������� ������ � ������� ��� ��������� ���������� � �������� �� ��������������
    $.ajax({
        url: '/api/vacancies/' + vacancyId,
        type: 'GET',
        headers: {
            Authorization: 'Bearer ' + token
        },
        success: function(vacancy) {
            displayVacancy(vacancy);
        },
        error: function() {
            console.log('������ ��� ���������� �������');
        }
    });

    function displayVacancy(vacancy) {
        // ���������� ���������� � �������� �� ��������
        $('.vacancy-section h1').text(vacancy.jobTitle);
        $('.vacancy-section .vacancy-image img').attr('src', vacancy.img);
        $('.vacancy-section .vacancy-details .vacancy-location').text(vacancy.location);
        $('.vacancy-section .vacancy-details .vacancy-salary').text(vacancy.salary);
        $('.vacancy-section .vacancy-details .vacancy-description').text(vacancy.description);
    }



    // ����������� ������
    $('#edit-vacancy').click(function() {
        // �������� ��� ������� �� ������ "�������� ��������"
        // ��������, ��������������� �� �������� �������������� ��������
        window.location.href = '/edit-vacancy?id=' + vacancyId;
    });

    $('#delete-vacancy').click(function() {
        // �������� ��� ������� �� ������ "������� ��������"
        // ��������, ����� ������� ��� �������� ��������
        deleteVacancy(vacancyId);
    });

    // $('#view-candidates').click(function() {
    //     $.ajax({
    //         url: '/api/vacancies/ '+ vacancyId+'/applicants',
    //         method: 'GET',
    //         success: function(response) {
    //             var candidates = response.candidates;
    //             if (Array.isArray(candidates) && candidates.length > 0) {
    //                 var candidatesList = $('#candidates-list');
    //                 candidatesList.empty();
    //
    //                 candidates.forEach(function(candidate) {
    //                     var candidateItem = $('<div>').addClass('candidate-item');
    //                     candidateItem.append($('<p>').html('<strong>���:</strong> ' + candidate.name));
    //                     candidateItem.append($('<p>').html('<strong>�������:</strong> ' + candidate.surname));
    //                     candidateItem.append($('<p>').html('<strong>��������:</strong> ' + candidate.patronymic));
    //                     candidateItem.append($('<p>').html('<strong>���� ��������:</strong> ' + candidate.date));
    //                     candidateItem.append($('<img>').attr('src', candidate.myPhoto).attr('alt', '����'));
    //                     candidateItem.append($('<p>').html('<strong>� ����:</strong> ' + candidate.aboutMe));
    //
    //                     candidatesList.append(candidateItem);
    //                 });
    //             } else {
    //                 console.log('��������� �� �������.');
    //             }
    //         },
    //         error: function() {
    //             alert('��������� ������ ��� ��������� ����������.');
    //         }
    //     });
    // });
});

function getVacancyIdFromURL() {
    // �������� ������������� �������� �� URL (��������, ����� �������� �������)
    // �������� ��� ��� ���������� �������������� �� URL
    // ������� �������������
}

function deleteVacancy(vacancyId) {
    // �������� ��� ��� �������� �������� � ������� ������� � �������
    // ����������� �������� �������� � ��������� ������
}
