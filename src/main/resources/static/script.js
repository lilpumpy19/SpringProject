document.addEventListener('DOMContentLoaded', function() {
    var registerLink = document.getElementById('register-link');

    registerLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �������� �����������, ��������:
        window.location.href = 'registration.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var homeLink = document.getElementById('home-link');

    homeLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'index.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var loginLink = document.getElementById('login-link');

    loginLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'login.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var aboutLink = document.getElementById('about-link');

    aboutLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'about_us.html';
    });
});

document.addEventListener('DOMContentLoaded', function() {
    var employersLink = document.getElementById('employers');

    employersLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'employers.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var jobLink = document.getElementById('job_search');

    jobLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'job_search.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var accountLink = document.getElementById('my_account');

    accountLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'my_account.html';
    });
});
document.addEventListener('DOMContentLoaded', function() {
    var jobLink = document.getElementById('job_search_2');

    jobLink.addEventListener('click', function(event) {
        event.preventDefault(); // �������� ����������� �������� �������� �� ������

        // ����� ����� ��������� �������� �� �������� �� ������� ��������, ��������:
        window.location.href = 'job_search.html';
    });
});

data.forEach(function(vacancy) {
    if (vacancy.title) {
        var vacancyCardTemplate = $('#vacancyCardTemplate').html();
        var vacancyCard = $(vacancyCardTemplate);

        vacancyCard.find('.vacancy-title').text(vacancy.title);
        vacancyCard.find('.vacancy-salary').text(vacancy.salary);
        vacancyCard.find('.vacancy-location').text(vacancy.location);

        $('#vacancyResults').append(vacancyCard);
    } else {
        console.log('����������� �������� ��������');
    }
});