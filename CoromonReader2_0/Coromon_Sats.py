# Add you code here
Coromon_data = open("CoromonDataset.csv",'r')

header = Coromon_data.readline()
Attributes = header.replace("\n","")
Attributes = Attributes.split(",")

Character_data = {}

for line in Coromon_data:
  line = line.replace("\n","")
  line = line.split(",")
  Character_data[line[0]] = {}
  for i in range(0,len(Attributes)):
    if  line[i].isdigit():
     Character_data[line[0]][Attributes[i]] = int(line[i])
     #print("is a digit")
    else:
     Character_data[line[0]][Attributes[i]] = line[i]
     #print("not digit")
Coromon_data.close()


#print(Character_data)
options = ["Analyze","Coromon"]
selected_option = "" 
   
while selected_option not in options: #menu 1
   selected_option = input("What do you want to do? [Analyze:Coromon]: ")
#Coromon option block///////////////////////////////////////////////////////////////////////////   
if selected_option == "Coromon":
     options_2 = ["Count", "Info"]
     selected_option_2 = ""
     while selected_option_2 not in options_2:
         selected_option_2 = input("What do you want to do? [Count:Info]: ")
     
     if selected_option_2 == "Count": #Menu 2
       options_3 = ["Cormons", "Types"]
       selected_option_3 = ""
       while selected_option_3 not in options_3:
         selected_option_3 = input("What would you like to count [Coromons:Types]: ")
         
       if selected_option_3 == "Cormons":
          print("There are", len(Character_data), "different Coromon's")
       
       elif selected_option_3 == "Types":       
          Coromon_names = list(Character_data.keys()) 
          Type_list = []
          for name in Coromon_names:
            if Character_data[name]['Type'] not in Type_list:
                Type_list.append(Character_data[name]['Type'])
            
          print("The existing types are", str(Type_list), "totaling to",len(Type_list),"different types")
     
     elif selected_option_2 == "Info":
       Coromon_names = list(Character_data.keys())  
       selected_Coromon = ""
       
       while selected_Coromon not in Coromon_names:
         selected_Coromon = input("What Coromon would you like info from? (type [List] for names): ")
         if selected_Coromon == "List":
           print(Coromon_names ,"\n")
      
       print(Character_data[selected_Coromon])
#///////////////////////////////////////////////////////////////////////////////////////////////
elif selected_option == "Analyze":
 
   stats = Character_data['Cubzero'].keys() #getting list for stat names
   stats = list(stats)
   stats = stats[2:] 


   #Getting a list of all the existing types
   Coromon_names = list(Character_data.keys()) 
   Type_list = []
   for name in Coromon_names:
       
     if Character_data[name]['Type'] not in Type_list:
       Type_list.append(Character_data[name]['Type']) 


   
   options_4 = ["Highest","Lowest","Average"]
   selected_option_4 = ""
   while selected_option_4 not in options_4:
     selected_option_4 = input("What would you like to Analyze? [Highest:Lowest:Average]: ")

   if selected_option_4 == "Average":
       stats_dic = {}
       for stat in stats:
            stats_dic[stat] = 0
      
      
      
       options_5 = ["Type","Overall"]
       selected_option_5 =""
       while selected_option_5 not in options_5:
         selected_option_5 = input("Would you like the average of a specific type or overall? [Type:Overall]")
       
       if selected_option_5 == "Overall":
         
         for character in list(Character_data.keys()):     
           
            for stat in stats:
             stats_dic[stat] = stats_dic[stat] + (Character_data[character][stat]/len(Character_data))
         
         for stat in stats: #Rounding pass over, We don't want long decimals numbers
            stats_dic[stat] = round(stats_dic[stat],0)
         print(stats_dic)


       elif selected_option_5 == "Type":
          selected_Type = ""
          while selected_Type not in Type_list:
            selected_Type = input("Which type do you want to average from? (Type 'List' for a list of types: ")
            if selected_Type == "List":
              print(Type_list,"\n")
          
          Type_Count = 0

          for character in list(Character_data.keys()):     
            if Character_data[character]['Type'] == selected_Type:
            
             for stat in stats:
                stats_dic[stat] = stats_dic[stat] + Character_data[character][stat]
                
             Type_Count += 1

          for stat in stats: #Rounding pass over, We don't want long decimals numbers
                stats_dic[stat] = round(stats_dic[stat]/Type_Count,0)
         
          print(stats_dic) 
   

   elif selected_option_4 == "Highest":

      options_6 = ["Type","Overall"]
      selected_option_6 = ""
      while selected_option_6 not in options_6:
        selected_option_6 = input("Would you like highest by type or overall? [Type:Overall]: ")
      
      
      character_with_highest = []
      greatest_stat = 0

      selected_stat = "" # Getting selected stat///////////////
      while selected_stat not in stats:
          selected_stat = input("Which stat do you want to average? (type 'List' for stats): ")
          if selected_stat == "List":
            print(stats,"\n")
      
      if selected_option_6 == "Overall":
        for character in Character_data.keys():
          if Character_data[character][selected_stat] > greatest_stat:
             greatest_stat = Character_data[character][selected_stat]
        
        
     
        for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
          if Character_data[character][selected_stat] == greatest_stat:
            character_with_highest.append(character)
       
        print(character_with_highest, greatest_stat)
        
      if selected_option_6 == "Type":
          selected_type = ""
          while selected_type not in Type_list:
            selected_type = input("What type would you like to analyze?: ")
          
          for character in Character_data.keys():
            if Character_data[character][selected_stat] > greatest_stat and Character_data[character]['Type'] == selected_type:
                 greatest_stat = Character_data[character][selected_stat]
          
          for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
            if Character_data[character][selected_stat] == greatest_stat and Character_data[character]['Type'] == selected_type:
                 character_with_highest.append(character)
          
          print(character_with_highest, greatest_stat) 
 

   elif selected_option_4 == "Lowest":

       
      options_6 = ["Type","Overall"]
      selected_option_6 = ""
      while selected_option_6 not in options_6:
        selected_option_6 = input("Would you like highest by type or overall? [Type:Overall]: ")
      
      
      character_with_highest = []
      lowest_stat = 9999

      selected_stat = "" # Getting selected stat///////////////
      while selected_stat not in stats:
          selected_stat = input("Which stat do you want to average? (type 'List' for stats): ")
          if selected_stat == "List":
            print(stats,"\n")
      
      if selected_option_6 == "Overall":
        for character in Character_data.keys():
          if Character_data[character][selected_stat] < lowest_stat:
             lowest_stat = Character_data[character][selected_stat]
        
        
     
        for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
          if Character_data[character][selected_stat] == lowest_stat:
            character_with_highest.append(character)
       
        print(character_with_highest, lowest_stat)
        
      if selected_option_6 == "Type":
          selected_type = ""
          while selected_type not in Type_list:
            selected_type = input("What type would you like to analyze?: ")
          
          for character in Character_data.keys():
            if Character_data[character][selected_stat] < lowest_stat and Character_data[character]['Type'] == selected_type:
                 lowest_stat = Character_data[character][selected_stat]
          
          for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
            if Character_data[character][selected_stat] == lowest_stat and Character_data[character]['Type'] == selected_type:
                 character_with_highest.append(character)
          
          print(character_with_highest, lowest_stat)




#// This program is a protoype. Go to Coromon_stats2.0 for finalized version

#def stat_analyzer(data)
#print(len(Character_data))