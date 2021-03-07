/**
  * transformers (transformations ir spark)
  *
  * LAZY
  *
  * return new collection as results (not single values)
  * exp: map, filter, flatMap, groupBy
  *
  * in Spark:
  * return new RDDs as a result
  */

/**
  * accessors (actions in spark)
  *
  * EAGER
  *
  * return single values as results (not collections)
  * exp: collect, count, take, reduce, fold, aggregate, foreach
  *
  * in Spark:
  * compute a result based on an RDD, and returned
  * or saved to an external storage system (e.g. HDFS)
  */

//val largeList: List[String] = ???
//val wordsRdd = sc.parallelize(largeList)
//val lengthsRdd = wordsRdd.map(_.length)
//
//// there nothing happened, because MAP used
//// add reduce then
//
//val totalChars = lengthsRdd.reduce(_ + _)

/**
  * other RDD actions
  *
  * takeSample
  * takeOrdered
  * saveAsTextFile
  * saveAsSequenceFile
  *
  */
