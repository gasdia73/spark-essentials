package part2DataFrames

import org.apache.spark.sql.SparkSession

object Exercise extends App {

  val spark = SparkSession.builder()
    .appName("DataFrames basics")
    .config("spark.master", "local")
    .getOrCreate()

  val phones = Seq(
    ("nokia", "nokia 3310", "300x200", 6),
    ("apple", "iphone 10", "3000x2000", 30),
    ("samsung", "galaxy 20", "3000x2000", 40)
  )
  val phonesDF = spark.createDataFrame(phones)
  phonesDF.printSchema()
  phonesDF.show()

  val moviesDF = spark.read.format("json").option("inferSchema", "true").load("src/main/resources/data/movies.json")
  moviesDF.printSchema()
  println(moviesDF.count())





}
