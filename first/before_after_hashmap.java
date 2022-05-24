import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
public class before_after_hashmap
{
public static void main(String args[]) throws IOException
{
Scanner sc=new Scanner(System.in);
HashMap<String, String> info = new HashMap<String, String>();
System.out.println("How many element you want to add add into Collection?");
int n=sc.nextInt();
System.out.println("Enter data in(data<space>data) format");
for(int i=0;i<n;i++)
{
String k=sc.next();
String v=sc.next();
info.put(k, v);
}
System.out.println("HashMap before sorting ");
Set<Entry<String, String>> entries = info.entrySet();
for(Entry<String, String> entry : entries)
{
System.out.println(entry.getKey() + "==>" + entry.getValue());
}
TreeMap<String, String> sorted = new TreeMap<>(info);
Set<Entry<String, String>> mappings = sorted.entrySet();
System.out.println("\nHashMap after sorting (by keys)");
for(Entry<String, String> mapping : mappings)
{
System.out.println(mapping.getKey() + "==> " + mapping.getValue());
}
Comparator<Entry<String, String>> valueComparator = new
Comparator<Entry<String,String>>()
{
@Override public int compare(Entry<String, String> e1, Entry<String,
String> e2)
{
String v1 = e1.getValue(); String v2 = e2.getValue(); return
v1.compareTo(v2);
}
};
List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String,
String>>(entries);
Collections.sort(listOfEntries, valueComparator);
LinkedHashMap<String, String> sortedByValue = new
LinkedHashMap<String, String>(listOfEntries.size());
for(Entry<String, String> entry : listOfEntries)
{
sortedByValue.put(entry.getKey(), entry.getValue());
}
System.out.println("\nHashMap after sorting (by values) ");Set<Entry<String, String>> entrySetSortedByValue =
sortedByValue.entrySet();
for(Entry<String, String> mapping : entrySetSortedByValue)
{
System.out.println(mapping.getKey() + "==> " + mapping.getValue());
}
}
}
