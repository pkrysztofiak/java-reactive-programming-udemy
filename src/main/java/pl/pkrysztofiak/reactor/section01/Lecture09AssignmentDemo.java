package pl.pkrysztofiak.reactor.section01;

import pl.pkrysztofiak.reactor.section01.assignment.FileService;
import pl.pkrysztofiak.reactor.utils.On;

import java.io.File;

public class Lecture09AssignmentDemo {

    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(On.next(), On.error(), On.complete());

//        FileService.write("file03.txt", "This is file 03")
//                .subscribe(On.next(), On.error(), On.complete());
        FileService.delete("file03.txt").subscribe(On.next(), On.error(), On.complete());
    }
}
