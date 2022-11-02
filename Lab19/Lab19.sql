-- TASK 1
select e.employee_name, d.department_name
from employee e 
inner join department d on d.department_id = e.department;  

-- TASK 2
select department_name, employee_name
from employee e
right join department d on d.department_id = e.department
order by department;

-- TASK 3
select e.employee_name, l.city
from employee e 
left join location l on e.location = l.location_id
where location is not null;

-- TASK 4
select employee_name
from employee
where department = 1
union 
select employee_name
from employee
where location = 1;

-- TASK 5
select employee_name
from employee
where department = 1
except 
select employee_name 
from employee
where location = 1;

-- TASK 6
select employee_name
from employee 
where department = 1
intersect
select employee_name 
from employee 
where location = 1;

