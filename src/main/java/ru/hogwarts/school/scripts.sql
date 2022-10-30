select *
from student;

select *
from student where age >= 12 and age <= 14;

select name
from student;

select *
from student
WHERE name like '%н%';

select *
from student
where age < student.id;