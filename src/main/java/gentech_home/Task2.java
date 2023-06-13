/*
========================================================================Используя БД hr:

1. Найти среднюю зарплату по компании

SELECT
	AVG(salary) AS average_salary
 FROM hr.employees;

ответ - 6461.682243 1 строка
---------------------------------------------------
2 Найти общее количество департаментов

SELECT
	COUNT(department_name) AS number_of_departments
 FROM hr.departments;

ответ 27
------------------------------------------------------------------
3 Найти количество департаментов, в которых никто не работает

SELECT
    count(t2.department_id)
 FROM hr.employees t1
 RIGHT JOIN departments t2
 ON t1.department_id = t2.department_id
 WHERE t1.first_name IS NULL;

ответ 17

------------------------------------------------------------------
4. Найти среднюю зарплату в департаменте с id 90

SELECT
	AVG(t1.salary) as average_salary
 FROM hr.employees t1
 INNER JOIN departments t2
 ON t1.department_id = t2.department_id
 WHERE t2.department_id = 90;

 ответ - 19333.33
---------------------------------------------------------------------------------------------
5. Найти самую большую зарплату среди сотрудников, работающих в департаментах с id 70 и 80

SELECT
	MAX(salary)
 FROM hr.employees
 WHERE department_id in("70" ,"80");

 ответ - 14000.00

===========================================================Используя БД SHOP:

1 Определить, сколько покупок было совершено в каждый месяц. Отсортировать строки
в порядке возрастания количества покупок. Вывести два поля - номер месяца и количество покупок

SELECT
	count(ORDER_ID) AS quantity_orders,
    MONTH(odate) AS num_month
 FROM shop.orders
 GROUP BY MONTH(odate)
 ORDER BY num_orders;
 ----------------------------------------------------------------
2 Определить, в какой месяц было совершено больше всего покупок.  Вывести два поля
- номер месяца и количество покупок

== подзапрос не удалось написать. сложновато. исспользую limit

SELECT
    MONTH(odate) AS num_month
FROM shop.orders
GROUP BY MONTH(odate)
ORDER BY quantity_orders DESC
LIMIT 1;

 */

