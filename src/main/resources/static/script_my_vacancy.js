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

    $('#view-candidates').click(function() {
        // Действия при нажатии на кнопку "Посмотреть кандидатов"
        // Например, перенаправление на страницу с кандидатами для данной вакансии
        window.location.href = '/candidates?vacancyId=' + vacancyId;
    });
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
