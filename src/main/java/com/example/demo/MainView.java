package com.example.demo;

import Entities.Student;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import repositories.StudentRepository;

import java.awt.*;

@Route("")
public class MainView extends VerticalLayout {
    private StudentRepository repository;
    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField courseEnrolled = new TextField("Course name");
    private Binder<Student> binder = new Binder<>(Student.class);
    private Grid<Student> grid = new Grid<>(Student.class);
    private StudentRepository ;

    public MainView(StudentRepository repository)
    {
        this.repository = repository;
        grid.setColumns("First name", "Last name", "Course name");

        add(getForm(), grid);
    }

    private Component getForm() {
        var layout = new HorizontalLayout();
        var addButton = new Button("Enroll");

        layout.setAlignItems(Alignment.BASELINE);
        layout.add(String.valueOf(firstName));
        layout.add(String.valueOf(lastName));
        layout.add(String.valueOf(courseEnrolled));
        layout.add(String.valueOf(addButton));
        binder.bindInstanceFields(this);
//        addButton.addMouseListener(click -> {
//            try {
//             var student = new Student();
//                // binder.writeBean(student);
//
//            } catch(ValidationException e)
//            {
//                //
//            }
//        });
        return layout;
    }
    private void refreshGrid()
    {
        grid.setItems(repository.findAll());
    }
}
