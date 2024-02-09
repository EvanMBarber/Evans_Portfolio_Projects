def format_to_dict(thefile): # Converting csv to dictionary
    
  Coromon_data = open(thefile,'r')
  
  header = Coromon_data.readline()
  Attributes = header.replace("\n","")
  Attributes = Attributes.split(",")

  #Initializing the dictionary
  Character_data = {}

  for line in Coromon_data:
    line = line.replace("\n","")
    line = line.split(",")
    Character_data[line[0]] = {}
    for i in range(0,len(Attributes)):
     #If statement is checking if the elements in the line is a digit or not. We want stored digits to be ints not string.
      if  line[i].isdigit():
       Character_data[line[0]][Attributes[i]] = int(line[i])

      else:
       Character_data[line[0]][Attributes[i]] = line[i]
  #Closing the file and returning the output(our dictionary)
  Coromon_data.close()
  return Character_data

Character_data = format_to_dict("CoromonDataset.csv")

def proper_format(string): # this is for formatting certain inputs by the user so that they work for dictionarys.
  
  string = string.split()
  
  new_string = []
  for word in string:
      word = word[0].upper() + word[1:].lower()
      new_string.append(word)
  new_string = " ".join(new_string)
  return new_string

def help_function(Character_data, command): # This function prints list and commands if the user doesn't know what to input.
    
  #Command comments
   command = command.lower()
   #creating coromon name list for the coromon list
   Coromon_names = list(Character_data.keys())

   if command == "help":
      return(print("'character list' will print a list of all Coromon names","\n", 
     "'type list' will print a list of all available types","\n",
     "'stat list' will print a list of all the different numerical stat names","\n",
     "'exit' will end the program","\n",
     "'back' will return you to the previous menu","\n",
     "'home' will return you to the first menu","\n",
     "'clear'will clear the terminal (sort of)" ))
   
   elif command == "clear":
      return(print("\n" * 10))

 
   elif command == "character list":
     
      return(print(Coromon_names,"\n"))
   
   elif command == "type list":
      #creating list for all existing Coromon types(element types)
      type_list = []
      for name in Coromon_names:

       if Character_data[name]['Type'] not in type_list:
         type_list.append(Character_data[name]['Type']) 


     
      return(print(type_list,"\n"))
   
   elif command == "stat list":

      stats = Character_data['Cubzero'].keys() 
      stats = list(stats)
      stats = stats[2:]

      return(print(stats,"\n"))
  
   else:
      return

def navigator(menu_id, command): #This is a function that dictates what menu youll get placed in and where you can go based on your position
  
  command = command.lower()
  
  if command == "exit": #This will return a value that terminates the program if true
    return 0
  
  elif command == "home":#This command returns the user to the first menu
    return 1



  if menu_id == 1: #What do you want to do? [Analyze:Coromon]
    if command == "coromon": #Keywords used to progress through the menu tree
      return 2
    elif command == "analyze":
      return 7
    return menu_id

  if menu_id == 2: #What do you want to do? [Count:Info]
    if command == "info":
      return 6
    elif command == "count":
      return 3
    elif command == "back":
      return 1
    return menu_id

  if menu_id == 3: #What do you want to count?[Type:Coromon]
     if command == "coromon":
       return 4
     elif command == "type":
       return 5
     elif command == "back":
       return 2
     return menu_id
 
  if menu_id == 4: #calculating number of coromons
     if command == "back":
       return 3
     else:
       return menu_id
  
  if menu_id == 5: #calculating number different types
     if command == "back":
       return 3
     else:
       return menu_id
 
  if menu_id == 6: #getting info on coromon
     if command == "back":
       return 2
     else:
       return menu_id
  
  if menu_id == 7: #"What would you like to Analyze? [Highest:Lowest:Average:]: "
     if command == "highest":
      return 11
     elif command == "average":
      return 8
     elif command == "lowest":
      return 15
     elif command == "back":
      return 1
     else:
       return menu_id
 
  if menu_id == 8: # Would you like the average of a specific type or overall? [Type:Overall]
     if command == "type":
      return 9
     elif command == "overall":
      return 10
     elif command == "back":
      return 7
     else:
       return menu_id
 
  if menu_id == 9: # Which type do you want to average from? (Type 'List' for a list of types):  
     if command == "back":
      return 8
     else:
       return menu_id

  if menu_id == 10: #Getting overall average for all coromon

     if command == "back":
      return 8
     else:
      return menu_id

  if menu_id == 11: # what would you analyze the highest stat by? [Type:Overall:Type with Highest]
     if command == "type":
      return 12
     elif command == "overall":
      return 14
     elif command == "type with highest":
      return 19
     elif command == "back":
      return 7
     else:
       return menu_id
  
  if menu_id == 12: # What type do you want to analyze highest from?
     if command == "valid type":
      return 13
     elif command == "back":
      return 11
     else:
       return menu_id
 
  if menu_id == 13: # What stat do you want to anaylze for the select type?
     if command == "back":
      return 12
     else:
       return menu_id
  
  if menu_id == 14: # What stat do you want to analyze from all coromon

    if command == "back":
      return 8
    else:
      return menu_id
  
  if menu_id == 15:  # what would you analyze the lowest stat by? [Type:Overall:Type with Lowest]
   
     if command == "type":
      return 16
     elif command == "overall":
      return 18
     elif command == "type with lowest":
      return 20
     elif command == "back":
      return 7
     else:
       return menu_id
 
  if menu_id == 16:  # What type do you want to analyze lowest from?
     
     if command == "valid type":
      return 17
     elif command == "back":
      return 15
     else:
       return menu_id
  
  if menu_id == 17:  # what stat do you want to analyze for the select type?
     
     if command == "back":
      return 16
     else:
      return menu_id
  
  if menu_id == 18:  # what stat do you want to analyze from all coromon?
     if command == "back":
      return 15
     else:
      return menu_id

  if menu_id == 19:
     if command == "back":
      return 11
     else:
      return menu_id

  if menu_id == 20:
      if command == "back":
       return 15
      else:
       return menu_id

  else:
       return menu_id
      
def Coromon_Analyzing_Program(Character_data):
  menu_id = 1
  
  while menu_id != 0: #Main porgram loop
    
    command = ""
    while menu_id == 1: #Each one of these is a menu that will ask you for an input
      command = input("what do you want to do: [Analyze:Coromon]: ")
      
      help_function(Character_data, command) #These are placed in every menu incase the user uses a special input like help ,exit ,character list
      menu_id = navigator(menu_id, command)  #These are also placed in every menu, this checks the user input is a possible input for the coresponding menu and relocates them if so
    
    while menu_id == 2:
        
      command = input("What do you want to know [Count:Info]: ")
     
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
     
    while menu_id == 3:
        
      command = input("What would you like to count? [Type:Coromon]: ")
      
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 4:
      command == command.lower() #Every input is lower cased so that inputs are not case sensitive.
      if command == "coromon": #these prevents the next from repeadly printing unless called again
        print("There are", len(Character_data), "different Coromon's","\n")
        
      command = input("What do you want to do? (type coromon to display the last text again): ")
      
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 5:
      command == command.lower()
      if command == "type": #these prevents the next from repeadly printing unless called again
        Coromon_names = list(Character_data.keys()) 
        type_list = []
        for name in Coromon_names:
          if Character_data[name]['Type'] not in type_list: #This if statement is iterating through every coromon and logging every type/element
            type_list.append(Character_data[name]['Type'])
        print(type_list, "giving a total of ", len(type_list),"different types","\n")
         
      command = input("What do you want to do? (type coromon to display the last text again): ")
      
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 6:
      
      Coromon_names = list(Character_data.keys())
      
      command = input("what Coromon do you want info on? (don't forget 'character list' will display all the Coromon names): ")
      command = proper_format(command) # This re formats the user's input to be in proper case format since dictionary calls are case sensitive otherwise we crash.
      if command in Coromon_names:
         print(Character_data[command])
    
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)

    while menu_id == 7:
      #Initializing list and dictionarys for future use
      stats = Character_data['Cubzero'].keys() #creating list for stat names. Should of probably of gotten the header instead in case Cubzero gets removed
      stats = list(stats)
      stats = stats[2:] 
      
      
      Coromon_names = list(Character_data.keys()) #Creating the coromon name list for future iterations
      type_list = []
      for name in Coromon_names:
            if Character_data[name]['Type'] not in type_list:
              type_list.append(Character_data[name]['Type'])


      command = input("What would you like to Analyze? [Highest:Lowest:Average]: ")

      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 8:
        
      command = input("Would you like the average of a specific type or overall? [Type:Overall]: ")
  
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 9:
      
      stats_dic = {} # creating list of all the numerical stat names.
      for stat in stats:
        stats_dic[stat] = 0

      command = input("What type would you like to average from? (type 'type list' for a list of types): ")
      command = proper_format(command) # This forces user input to be in proper case format since dictionary calls are case sensitive.

      if command in type_list:
        type_Count = 0 #Getting the total amount of coromons of the selected type/element
     
        for character in list(Character_data.keys()):     
           if Character_data[character]['Type'] == command:
            
            for stat in stats:
               stats_dic[stat] = stats_dic[stat] + Character_data[character][stat]
                
            type_Count += 1

        for stat in stats: #Rounding pass over, We don't want long decimals numbers
                
               stats_dic[stat] = round(stats_dic[stat]/type_Count,1)
         
        print("Average stats for ", command, stats_dic, type_Count)

      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
    
    while menu_id == 10:
     
     stats_dic = {} # creating list of all the numerical stat names.
     for stat in stats:
        stats_dic[stat] = 0

     command = command.lower()
     if command == "overall":
      
      for character in list(Character_data.keys()):     
           
         for stat in stats:
             stats_dic[stat] = stats_dic[stat] + (Character_data[character][stat]/len(Character_data))
         
         for stat in stats: #Rounding pass over, We don't want long decimals numbers
            stats_dic[stat] = round(stats_dic[stat],1)
        
      print("The overall stats for all coromons is ",stats_dic)
      
      command = input("Type 'overall' again to repeat: ")
  
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
  
    while menu_id == 11:
      
      command = input("Would you like the highest of a specific type or overall? [Type:Overall:Type with Highest]: ")
  
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
  
    while menu_id == 12:
      
      selected_type = "" 
      command = input("What type do you want to average the highest from?(type 'type list' for list of types): ")
      command = proper_format(command) # This forces user input to be in proper case format since dictionary calls are case sensitive.
      selected_type = command

      if selected_type in type_list:
        command = "valid type"
      
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)
   
    while menu_id == 13:
      
      character_with_highest = []
      greatest_stat = 0
      
      selected_stat = ""
      command = input("What stat do you want to get the highest from? (type 'stat list' for list of numerical stats): ")
      command = proper_format(command) # This forces user input to be in proper case format so that input is not case sensitive
      selected_stat = command
     
     
      if selected_stat in stats:  #This will check too see if command is something that can go into the dictionary call, so to not cause a runtime error
        for character in Character_data.keys():
            if Character_data[character][selected_stat] > greatest_stat and Character_data[character]['Type'] == selected_type:
                 greatest_stat = Character_data[character][selected_stat]
          
        for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
            if Character_data[character][selected_stat] == greatest_stat and Character_data[character]['Type'] == selected_type:
                 character_with_highest.append(character)
          
        print("The fallowing character(s) in the",selected_type, "catagory with the highest", selected_stat, "are", character_with_highest, "with", greatest_stat, "points") 
     
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)

    while menu_id == 14:
        
      character_with_highest = []  #Initializing list so that we can store the coromon/s with the highest stat
      greatest_stat = 0 #Initializing variable to hold greatest stat

      selected_stat = ""
      command = input("What stat do you want to get the highest from? (type 'stat list' for list of numerical stats): ")
      command = proper_format(command) # This re formats the user's input to be in proper case format so that input is not case sensitive
      selected_stat = command

      if selected_stat in stats: #This will check too see if command is something that can go into the dictionary call, so to not cause a runtime error
        for character in Character_data.keys():
          if Character_data[character][selected_stat] > greatest_stat:
              greatest_stat = Character_data[character][selected_stat]
        
        
     
        for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
          if Character_data[character][selected_stat] == greatest_stat:
              character_with_highest.append(character)
       
        print("The fallowing character(s) with the highest",selected_stat, "are", character_with_highest, "with", greatest_stat, "points")
      help_function(Character_data, command)
      menu_id = navigator(menu_id, command)

    while menu_id == 15:
        
        command = input("Would you like the lowest of a specific type or overall? [Type:Overall:Type with Lowest]: ")
  
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)

    while menu_id == 16:
      
        selected_type = "" 
        command = input("What type do you want to average the highest from?(type 'type list' for list of types): ")
        command = proper_format(command) # This forces user input to be in proper case format since dictionary calls are case sensitive.
        selected_type = command

        if selected_type in type_list: #The user selects a type in this menu and the program will check if its a valid type, if it is the program will use the input as a dictionary input
          command = "valid type"
      
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)
    
    while menu_id == 17:
     
        character_with_lowest = []
        lowest_stat = 9999 #We set stat to 9999 instead of 0 otherwise it would always be 0 while looking for lowest stat

        selected_stat = ""
        command = input("What stat do you want to get the lowest from? (type 'stat list' for list of numerical stats): ")
        command = proper_format(command) # This re formats the users input to be in proper case format so that input is not case sensitive
        selected_stat = command

        if selected_stat in stats: #This will check too see if command is something that can go into the dictionary call, so to not cause a runtime error
          for character in Character_data.keys():
            if Character_data[character][selected_stat] < lowest_stat:
              lowest_stat = Character_data[character][selected_stat]
        
        
     
          for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
            if Character_data[character][selected_stat] == lowest_stat:
                character_with_lowest.append(character)
       
          print("The fallowing character(s) in the",selected_type, "catagory with the lowest", selected_stat, "are", character_with_lowest, "with", lowest_stat, "points")
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)
 
    while menu_id == 18:
    
        character_with_lowest = []
        lowest_stat = 9999
        
        selected_stat = ""
        command = input("What stat do you want to get the lowest from? (type 'stat list' for list of numerical stats): ")
        command = proper_format(command) # This forces user input to be in proper case format so that input is not case sensitive
        selected_stat = command

        if selected_stat in stats: #This will check too see if command is something that can go into the dictionary call, so to not cause a runtime error
          for character in Character_data.keys():
            if Character_data[character][selected_stat] < lowest_stat:
               lowest_stat = Character_data[character][selected_stat]
        
        
     
          for character in Character_data.keys(): #Loop is to find charcters who tie for highest/lowest stats and makes a list
            if Character_data[character][selected_stat] == lowest_stat:
              character_with_lowest.append(character)
     
          print("The fallowing character(s) with the lowest",selected_stat, "are", character_with_lowest, "with", lowest_stat, "points")
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)

    while menu_id == 19:
        type_dict = {} #Creating a dictionary to keep a log of all the types and also accumulating the total stats of each type
        for name in Coromon_names:
        
          if Character_data[name]['Type'] not in type_dict:
              type_dict[Character_data[name]['Type']] = 0
        
        type_count_dict = {}  #Creating a dictionary to keep a log of all the types and the amount of coromon of said type, to use to divide by later for proper average
        for name in Coromon_names:
        
          if Character_data[name]['Type'] not in type_count_dict:
              type_count_dict[Character_data[name]['Type']] = 0


        selected_stat = ""
        command = input("Which stat are you wanting the highest from?: ")
        command = proper_format(command) # This re formats the users input to be in proper case format so that input is not case sensitive
        selected_stat = command
        
        if selected_stat in stats:
          
          for name in Character_data.keys():
             type_dict[Character_data[name]['Type']] += Character_data[name][selected_stat]
             type_count_dict[Character_data[name]['Type']] += 1

          
          highest = 0
          for Type in type_dict:
              type_dict[Type] = type_dict[Type]/type_count_dict[Type]
              round(type_dict[Type],1)
              if type_dict[Type] > highest:
                 highest = type_dict[Type]
          
          type_with_highest = []

          for Type in type_dict:
            if type_dict[Type] == highest:
              type_with_highest.append(Type)
       
          print(type_with_highest, "Has the greatest average in", selected_stat)
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)

    while menu_id == 20:
        type_dict = {}
        for name in Coromon_names:
        
          if Character_data[name]['Type'] not in type_dict:
              type_dict[Character_data[name]['Type']] = 0
        
        type_count_dict = {}
        for name in Coromon_names:
        
          if Character_data[name]['Type'] not in type_count_dict:
              type_count_dict[Character_data[name]['Type']] = 0


        selected_stat = ""
        command = input("Which stat are you wanting the lowest from?: ")
        command = proper_format(command) # This forces user input to be in proper case format so that input is not case sensitive
        selected_stat = command
        
        if selected_stat in stats:
          
          for name in Character_data.keys():
             type_dict[Character_data[name]['Type']] += Character_data[name][selected_stat]
             type_count_dict[Character_data[name]['Type']] += 1

          lowest = 9999
          for Type in type_dict:
              type_dict[Type] = type_dict[Type]/type_count_dict[Type]
              round(type_dict[Type],1)
              if type_dict[Type] < lowest:
                 lowest = type_dict[Type]
          
          type_with_lowest = []
         
          for Type in type_dict:
            if type_dict[Type] == lowest:
              type_with_lowest.append(Type)
            

       
          print(type_with_lowest, "Has the lowest average in", selected_stat)
        help_function(Character_data, command)
        menu_id = navigator(menu_id, command)
  
  
  
  
  
  
  
  return(print("Program closedxxxx"))


Coromon_Analyzing_Program(Character_data)