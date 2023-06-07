    /*
1 Найти компетенции, которых нет ни у одного преподавателя.

        SELECT
            t3.title
        FROM uni.teachers t1
        INNER JOIN teachers2competencies t2
        ON t1.id = t2.teacher_id
        RIGHT JOIN competencies t3
        ON t2.competencies_id = t3.id
        WHERE t1.name is null;

ответ - Графика 1 строка

2 Вывести название курса и имя старосты

        SELECT
            t2.name,
            t1.title
        FROM uni.courses t1
        INNER JOIN students t2
        ON t1.headman_id = t2.id;

ответ 5 строк

        Анатолий	Алгебра логики
        Олег	    Математическая статистика
        Олеся	    Высшая математика
        Семен	    Javascript
        Семен	    Базовый Python

3 Вывести имя студента и имена старост, которые есть на курсах, которые он проходит.

        SELECT
            t1.name as student_name,
            t4.name as head_name
        FROM uni.students t1
        INNER JOIN students2courses t2
        ON t1.id = t2.student_id
        INNER JOIN courses t3
        ON t2.course_id = t3.id
        INNER JOIN students t4
        ON t3.headman_id = t4.id;

ответ 5 строк

        Анатолий	Анатолий
        Олег	    Олег
        Олег	    Олеся
        Семен	    Анатолий
        Семен	    Семен
     */

