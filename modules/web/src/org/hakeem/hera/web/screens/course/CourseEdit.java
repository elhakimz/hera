package org.hakeem.hera.web.screens.course;

import com.haulmont.cuba.gui.screen.*;
import org.hakeem.hera.entity.qualification.Course;

@UiController("hera_Course.edit")
@UiDescriptor("course-edit.xml")
@EditedEntityContainer("courseDc")
@LoadDataBeforeShow
public class CourseEdit extends StandardEditor<Course> {
}