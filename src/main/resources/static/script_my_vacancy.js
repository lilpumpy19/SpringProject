
var token = localStorage.getItem('token');
$(document).ready(function() {
    var urlParams = new URLSearchParams(window.location.search);
    var vacancyId = urlParams.get('vacancyId'); // Получите идентификатор вакансии из URL (например, через параметр запроса)
    console.log('sssssssssss');
    // Выполните запрос к серверу для получения информации о вакансии по идентификатору
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
            console.log('Ошибка при выполнении запроса');
        }
    });

    function displayVacancy(vacancy) {
        // Отображаем информацию о вакансии на странице
        $('.vacancy-section h1').text(vacancy.jobTitle);
        $('.vacancy-section .vacancy-image img').attr('src', vacancy.img);
        $('.vacancy-section .vacancy-details .vacancy-location').text(vacancy.location);
        $('.vacancy-section .vacancy-details .vacancy-salary').text(vacancy.salary);
        $('.vacancy-section .vacancy-details .vacancy-description').text(vacancy.description);
    }



    // Обработчики кнопок
    $('#edit-vacancy').click(function() {
        // Действия при нажатии на кнопку "Изменить вакансию"
        // Например, перенаправление на страницу редактирования вакансии
        window.location.href = '/edit-vacancy?id=' + vacancyId;
    });

    $('#delete-vacancy').click(function() {
        // Действия при нажатии на кнопку "Удалить вакансию"
        // Например, вызов функции для удаления вакансии
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
    //                     candidateItem.append($('<p>').html('<strong>Имя:</strong> ' + candidate.name));
    //                     candidateItem.append($('<p>').html('<strong>Фамилия:</strong> ' + candidate.surname));
    //                     candidateItem.append($('<p>').html('<strong>Отчество:</strong> ' + candidate.patronymic));
    //                     candidateItem.append($('<p>').html('<strong>Дата рождения:</strong> ' + candidate.date));
    //                     candidateItem.append($('<img>').attr('src', candidate.myPhoto).attr('alt', 'Фото'));
    //                     candidateItem.append($('<p>').html('<strong>О себе:</strong> ' + candidate.aboutMe));
    //
    //                     candidatesList.append(candidateItem);
    //                 });
    //             } else {
    //                 console.log('Кандидаты не найдены.');
    //             }
    //         },
    //         error: function() {
    //             alert('Произошла ошибка при получении кандидатов.');
    //         }
    //     });
    // });
});

function getVacancyIdFromURL() {
    // Получите идентификатор вакансии из URL (например, через параметр запроса)
    // Напишите код для извлечения идентификатора из URL
    // Верните идентификатор
}

function deleteVacancy(vacancyId) {
    // Напишите код для удаления вакансии с помощью запроса к серверу
    // Обработайте успешное удаление и возможные ошибки
}
